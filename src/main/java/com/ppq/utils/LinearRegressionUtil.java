package com.ppq.utils;

import org.apache.commons.math3.stat.regression.RegressionResults;
import org.apache.commons.math3.stat.regression.SimpleRegression;

public class LinearRegressionUtil {
    public double[] regression(double[][] points){
        double[] res = new double[2];
        SimpleRegression regression = new SimpleRegression();
        regression.addData(points); // 数据集
        /*
         * RegressionResults 中是拟合的结果
         * 其中重要的几个参数如下：
         *   parameters:
         *      0: b
         *      1: k
         *   globalFitInfo
         *      0: 平方误差之和, SSE
         *      1: 平方和, SST
         *      2: R 平方, RSQ
         *      3: 均方误差, MSE
         *      4: 调整后的 R 平方, adjRSQ
         *
         * */
        RegressionResults results = regression.regress();
        res[0] = results.getParameterEstimate(0);
        res[1] = results.getParameterEstimate(1);
        return res;
    }
}
