# coding=utf-8

import numpy as np
import math
import matplotlib.pyplot as plt
import copy as cp

#检测初始中心点是否靠得过近
def isdistinct(means,criter=0.03):
    K = len(means)
    for i in range(K):
        for j in range(i+1,K):
            if criter > np.linalg.norm(means[i]-means[j]):
                return 0       
    return True

#获取初始聚簇中心
def getmeans(data,K,criter):
    means = [0]*K
    dim  = np.shape(data)[1]
    #各个维度的极大极小值
    minmax = [] 
    for i in range(dim):
        minmax.append(np.array([min(data[:,i]),max(data[:,i])]))

    while True:
        #生成初始点的坐标
        for i in range(K):
            means[i] = []
            for j in range(dim):
                means[i].append(np.random.random()*(minmax[j][1]-minmax[j][0])+minmax[j][0])  
            means[i] = np.array(means[i])

        if isdistinct(means,criter):
            break  
    return means

# k-means算法的实现函数。
#用K-means算法输出的聚类中心，作为高斯混合模型的输入
def kmeans(data,K):
    N = np.shape(data)[0]#样本数目
    dim = np.shape(data)[1] #维度

    means = getmeans(data,K,criter=15)
    means_old = [np.zeros(dim) for k in range(K)]

    while np.sum([np.linalg.norm(means_old[k]-means[k]) for k in range(K)]) > 0.01:

        means_old = cp.deepcopy(means)

        numlog = [0]*K
        sumlog = [np.zeros(dim) for k in range(K)]
        for n in range(N):
            distlog = [np.linalg.norm(data[n]-means[k]) for k in range(K)]
            toK = distlog.index(np.min(distlog))

            numlog[toK] += 1
            sumlog[toK] += data[n]

        for k in range(K):
            means[k] = 1.0/numlog[k]*sumlog[k]
    return means

# 读取同目录下的TestSet.txt文件，获取数据
def loadData(fileName):
	# 获取数据集    
    dataMat = []                
    fr = open(fileName)
    for line in fr.readlines():
        curLine = line.strip().split('\t')
        fltLine = map(float,curLine) 
        dataMat.append(fltLine)
    # 数据集大小为m
    m = len(dataMat)
    data = np.zeros((m,2))
    # 转换为array类型
    for i in range(m):
        data[i] = np.array(dataMat[i])
    return data

def init_param(data, K):
	# 均值mu初始化
	# mus = np.ones((K, 2))
	mus = kmeans(data, K)

	#获取初始协方差矩阵sigma(源自于原始数据的协方差矩阵)
	sigmas = [0]*K
	for i in range(K):
		sigmas[i] = np.cov(data.T)

	# 每个高斯分布的概率Pi初始化
	Pi = [1.0 / K] * K

	# 返回初始化的值
	return mus, sigmas, Pi

# 多元正态分布概率密度函数
def prob_density(sigma, x, mu):
	# 数据维度dim
	dim = np.shape(sigma)[0]
	# 加入单位矩阵防止行列式为0
	sigma = sigma+np.eye(dim)*0.01
	# 协方差矩阵的行列式的平方根
	sqrt_sigma = np.sqrt(np.abs(np.linalg.det(sigma)))
	# 协方差矩阵的逆
	inv_sigma = np.linalg.inv(sigma)
	x_diff = x - mu
	x_diff_trans = np.transpose(x_diff)
	# 计算概率密度
	result = (1.0/(np.power(2*np.pi,1.0*dim/2)*sqrt_sigma))*math.exp(-0.5*np.dot(np.dot(x_diff, inv_sigma), x_diff_trans))
	return result

# EM算法的E-step...
def E_step(data,K,mu,sigma,Pi):
	# 数据大小为m
	m = len(data)
	# 隐含变量z的分布gama_k，即数据x(i)由component k生成的概率，E-step更新此值
	gamas = np.zeros((m, K))
	for i in range(m):
		# 后验概率和权值因子的乘积
		product = [Pi[k]*prob_density(sigma[k], data[i], mu[k]) for k in range(K)]
		# 计算后验概率和权值因子的乘积之和
		sum_product = np.sum(product)
		# 计算每个gama(i,k)的值
		for k in range(K):
			gamas[i][k] = product[k] / sum_product
	return gamas

# EM算法的M-step...
def M_step(data,gamas,K):
	# 数据集大小设置为m
	m = len(data)
	# 计算Nk即gama(i,k)列表的和
	N = [0] * K 					# 初始化N
	Pi = [1.0 / K] * K 				# 初始化Pi
	new_mu = np.zeros((K, 2))		# 初始化mu
	new_sigma = np.zeros((K, 2, 2)) # 初始化sigma
	for k in range(K):
		# 计算N[k]
		N[k] = np.sum([gamas[i][k] for i in range(m)])

		# 更新mu_k
		# 计算gama(i,k)同下x(i)的乘积之和
		sum1 = np.sum([gamas[i][k] * data[i] for i in range(m)], axis=0)
		new_mu[k] = sum1 / N[k]

		# 更新sigma_k
		x_diff = data - new_mu[k]
		sum2 = np.sum([gamas[i][k]*x_diff[i].reshape(2, 1)*x_diff[i] for i in range(m)], axis=0)
		new_sigma[k] = sum2 * 1.0 / N[k]

		# 更新Pi_k
		Pi[k] = N[k] * 1.0 / m

	# 返回更新后的均值mu，方差sigma和权值因子Pi
	return new_mu, new_sigma, Pi

def EM_iteration(data,K):
	# 数据集大小设置为m
	m = len(data)
	# 引入初始参数
	mu, sigma, Pi = init_param(data, K)
	# 设置迭代停止阙值esp
	esp = 0.0001
	# 最大似然函数取对数loglikelyhood
	loglikelyhood = 0
	oldloglikelyhood = 1
	while np.abs(loglikelyhood - oldloglikelyhood) > esp:
		oldloglikelyhood = loglikelyhood
		# E-step更新gamas 
		gamas = E_step(data,K,mu,sigma,Pi)
		# M-step更新均值mu,方差sigma,权值因子Pi
		mu, sigma, Pi = M_step(data,gamas,K)
		# 计算最大似然函数值，用以判断是否停止迭代
		loglikelyhood = np.sum([np.log(np.sum([Pi[k]*prob_density(sigma[k], data[i], mu[k]) for k in range(K)])) for i in range(m)])
	return mu,sigma,gamas

#对程序结果进行可视化，注意这里的K只能取2，否则该函数运行出错
def visualresult(data,gammas,K,mu,sigma):
    N = np.shape(data)[0]#样本数目
    dim = np.shape(data)[1] #维度

    minmax = [] #各个维度的极大极小值
    xy = []
    n=200
    for i in range(dim):
        delta = 0.05*(np.max(data[:,i])-np.min(data[:,i]))
        xy.append(np.linspace(np.min(data[:,i])-delta,np.max(data[:,i])+delta,n))
    xx,yy = np.meshgrid(xy[0], xy[1])
    zz = np.zeros((n,n))
    for i in range(n):
        for j in range(n):
            zz[i][j] = np.sum(prob_density(sigma[k],np.array([xx[i][j],yy[i][j]]),mu[k]) for k in range(K))
    gci = plt.imshow(zz,origin='lower',alpha = 0.8) # 选项origin='lower' 防止tuixan图像颠倒
    plt.xticks([0,len(xy[0])-1],[xy[0][0],xy[0][-1]])
    plt.yticks([0,len(xy[1])-1],[xy[1][0],xy[1][-1]])

    for i in range(N):
        if gammas[i][0] >0.5:
            plt.plot((data[i][0]-np.min(data[:,0]))/(xy[0][1]-xy[0][0]),(data[i][1]-np.min(data[:,1]))/(xy[1][1]-xy[1][0]),'r.')
        else:
            plt.plot((data[i][0]-np.min(data[:,0]))/(xy[0][1]-xy[0][0]),(data[i][1]-np.min(data[:,1]))/(xy[1][1]-xy[1][0]),'k.')

    deltax = xy[0][1]-xy[0][0]
    deltay = xy[1][1]-xy[1][0]

    plt.plot((mu[0][0]-xy[0][0])/deltax,(mu[0][1]-xy[1][0])/deltay,'*r',markersize=15)
    plt.plot((mu[1][0]-xy[0][0])/deltax,(mu[1][1]-xy[1][0])/deltay,'*k',markersize=15)

    plt.title(u'EM算法进行高斯混合聚类',{'fontname':'STFangsong','fontsize':18})
    plt.show()

if __name__ == '__main__':
	data = loadData('TrainSet.txt')
	# 设置高斯混合分布的K值
	K = 2
	mu,sigma,gamas = EM_iteration(data,K)
	print "最终的参数值:"
	print "mu: ",mu
	for i in range(len(sigma)):
		print "sigma",i,":",sigma[i]
	visualresult(data,gamas,K,mu,sigma)
