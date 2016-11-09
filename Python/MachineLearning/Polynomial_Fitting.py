#-*- coding:utf-8 -*-

import numpy as np
from scipy.optimize import leastsq
import pylab as pl

# 定义多项式阶数为k
k = 13
# 定义正则化系数regularization
regularization = 0.001

# 目标函数
def real_func(input_x):
    return np.sin(2*np.pi*input_x)

# 定义拟合函数
def fitting_func(input_x, param_w):
    # 产生一个参数为param_P的多项式f
    f = np.poly1d(param_w)
    return f(input_x)

# 残差函数
def sq_residuals(param_w, input_x, noise_y):
    result = noise_y - fitting_func(input_x, param_w)
    return result

# 误差函数加上惩罚项(正则化)
def sq_re_residuals(param_w, input_x, noise_y):
    result = noise_y - fitting_func(input_x, param_w)
    result = np.append(result, np.sqrt(regularization)*param_w)
    return result

# 最小二乘法进行多项式拟合
def Linear_Fitting( ):
    #生成数据
    input_x = np.linspace(0, 1, 30)

    #真实数据
    real_y = real_func(input_x);

    #加入高斯噪声之后，y的值
    noise_y = 0.2*np.random.randn(len(input_x)) + real_y

    #在图中作出数据点
    pl.plot(input_x, noise_y, 'ro', label="data with noise")

    #使用python库函数随机生成最开始的拟合参数param_P
    fitting_param = np.random.randn(k)

    #使用python库函数leastsq行曲线拟合
    lsq_result = leastsq(sq_residuals, fitting_param, args=(input_x, noise_y))
    lsq_re_result = leastsq(sq_re_residuals, fitting_param, args=(input_x, noise_y))

    #生成随机拟合数据的x值
    x_points = np.linspace(0,1,1000)

    #在图中作出拟合曲线
    pl.plot(x_points, fitting_func(x_points,lsq_result[0]), 'g', label="non-re-fitting line")
    pl.plot(x_points, fitting_func(x_points,lsq_re_result[0]), 'b', label="re-fitting line")

    pl.legend()
    pl.show()

if __name__ == '__main__':
    Linear_Fitting()
