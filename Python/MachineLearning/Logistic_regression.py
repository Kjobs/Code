#-*- coding:utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt

# 回归函数，将数据控制在0，1之间
def sigmoid(X):
	return 1.0/(1+np.exp(-X))

# Logistic Regession 数据训练(无惩罚项)
def LR_train(train_x, train_y, opt_params):
	m, Features = np.shape(train_x) # m为样本数量，Features为特征数量
	alpha = opt_params['alpha'] # 步长
	Iters = opt_params['Iters'] # 迭代次数
	Thetas = np.ones((Features, 1)) # 权重，并将其初始化为1
	Theta0 = Thetas

	# 梯度下降法，多次迭代求得最优值
	for k in xrange(Iters):
		h_theta = sigmoid(train_x * Thetas)
		loss = h_theta - train_y # 损失函数计算
		# 不带惩罚项的θ值更新
		Thetas = Thetas - (alpha*train_x.transpose()*loss)/m

	# 返回系数Thetas
	return Thetas

# Logistic Regession正则化数据训练(加惩罚项)
def LR_RE_train(train_x, train_y, opt_params, Lambda):
	m, Features = np.shape(train_x) # m为样本数量，Features为特征数量
	alpha = opt_params['alpha'] # 步长
	Iters = opt_params['Iters'] # 迭代次数
	Thetas = np.ones((Features, 1)) # 权重，并将其初始化为1
	Theta0 = Thetas

	# 梯度下降法，多次迭代求得最优值
	for k in xrange(Iters):
		h_theta = sigmoid(train_x * Thetas)
		loss = h_theta - train_y # 损失函数计算
		# 带惩罚项的θ值更新
		Thetas = (1 - Lambda / m) * Thetas - (alpha*train_x.transpose()*loss)/m

	# 返回系数Thetas
	return Thetas

def LR_test(test_x, test_y, Thetas):
	m, Features = np.shape(test_x)
	matchCount = 0
	for i in xrange(m):
		predict = sigmoid(test_x[i, :] * Thetas)[0, 0] > 0.5
		if predict == bool(test_y[i, 0]):
			matchCount += 1
	# 计算精度
	accuracy = float(matchCount) / m
	return accuracy

def Display_LR_graph(Thetas, data_x, data_y):
	m, Features = np.shape(data_x)
	if Features != 3:
		return

	# 画出数据分布情况
	for i in xrange(m):
		if int(data_y[i, 0]) == 0:
			plt.plot(data_x[i, 1], data_x[i, 2], 'or')
		elif int(data_y[i, 0]) == 1:
			plt.plot(data_x[i, 1], data_x[i, 2], 'ob')

	# 作回归分类线
	min_x = min(data_x[:, 1])[0, 0]
	max_x = max(data_x[:, 1])[0, 0]
	Thetas = Thetas.getA()
	y_min_x = float(-Thetas[0] - Thetas[1] * min_x) / Thetas[2]
	y_max_x = float(-Thetas[0] - Thetas[1] * max_x) / Thetas[2]
	plt.plot([min_x, max_x], [y_min_x, y_max_x], '-g')
	plt.xlabel('X1')
	plt.ylabel('X2')
	plt.show()

# 加载数据
def Load_data(file_name):
    data_x =[]
    data_y =[]
    fileInfo = open(file_name)
    for line in fileInfo.readlines():
        lineArr = line.strip().split()
        data_x.append([1.0, float(lineArr[0]), float(lineArr[1])])
        data_y.append(float(lineArr[2]))
    return np.mat(data_x), np.mat(data_y).transpose()

# 逻辑回归测试
def Logistic_reg_test():
	# 加载训练集和测试集数据
	train_x, train_y = Load_data('TrainSet.txt')
	test_x, test_y = Load_data('TestSet.txt')

	# 进行数据训练
	opt_params = {'alpha':0.1, 'Iters':1000}
	opt_Thetas1 = LR_train(train_x, train_y, opt_params)
	# 带惩罚项Lambda  λ
	Lambda = 0.0001
	opt_Thetas2 = LR_RE_train(train_x, train_y, opt_params, Lambda)

	# 进行数据测试
	accuracy1 = LR_test(test_x, test_y, opt_Thetas1)
	print "accuracy: ",accuracy1
	accuracy2 = LR_test(test_x, test_y, opt_Thetas2)
	print "accuracy2: ",accuracy2

	# 显示测试结果
	Display_LR_graph(opt_Thetas1, train_x, train_y)
	Display_LR_graph(opt_Thetas2, train_x, train_y)

if __name__ == '__main__':
	Logistic_reg_test()
	
