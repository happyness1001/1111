package com.ppq.utils;

import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.fitting.CurveFitter;
import org.apache.commons.math3.fitting.SimpleCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer;

import java.util.Arrays;

public class CustomizeCurveFitterTest {
    class MyFunction implements ParametricUnivariateFunction {
        //计算函数的值。
        public double value(double x, double ... parameters) {
            double a = parameters[0];
            double b = parameters[1];
            double c = parameters[2];
            double d = parameters[3];
            double e = parameters[4];

            return e+d + ((a - d) / (1 + Math.pow(x / c, b)));

        }
        //计算函数相对于其参数的梯度。
        public double[] gradient(double x, double ... parameters) {
            double a = parameters[0];
            double b = parameters[1];
            double c = parameters[2];
            double d = parameters[3];
            double e = parameters[4];

            double[] gradients = new double[5];
            double den = 1 + Math.pow(x / c, b);

            gradients[0] = 1 / den; // 对 a 求导

            gradients[1] = -((a - d) * Math.pow(x / c, b) * Math.log(x / c)) / (den * den); // 对 b 求导

            gradients[2] = (b * Math.pow(x / c, b - 1) * (x / (c * c)) * (a - d)) / (den * den); // 对 c 求导

            gradients[3] = 1 - (1 / den); // 对 d 求导

            gradients[4] = 1; // 对 e 求导
            return gradients;

        }
    }

    ParametricUnivariateFunction function = new MyFunction();
    // 生成待拟合数据
    public double[][] getPoints(ParametricUnivariateFunction function,double[] value) {
        double[][] xy = new double[6][2];
        xy[0] = new double[]{15, 4453};
        xy[1] = new double[]{31, 8503};
        xy[2] = new double[]{62, 17596};
        xy[3] = new double[]{125, 30592};
        xy[4] = new double[]{250, 45097};
        xy[5] = new double[]{500, 50693};
        return xy;

    }

    public void curveFitter() {
        ParametricUnivariateFunction function = new MyFunction();/*多项式函数*/
        double[] guess = {1500, 0.95, 65, 35000,10}; /*猜测值 依次为 a b c d 。必须和 gradient 方法返回数组对应*/
        double[][] points = getPoints(function, guess);/*待拟合数据*/

        // 初始化拟合
        SimpleCurveFitter curveFitter = SimpleCurveFitter.create(function,guess);

        // 添加数据点。带权重的点，我的理解这个点权重越大，拟合出来的曲线会更靠近这个点
        WeightedObservedPoints observedPoints = new WeightedObservedPoints();
        for (double[] point : points) {
            observedPoints.add(point[0], point[1]);
        }
        /*
         * best 为拟合结果 对应 a b c d
         * 可能会出现无法拟合的情况
         * 需要合理设置初始值
         * */
        double[] best = curveFitter.fit(observedPoints.toList());
        System.out.println(Arrays.toString(best));


        LevenbergMarquardtOptimizer optimizer = new LevenbergMarquardtOptimizer();
        CurveFitter<ParametricUnivariateFunction> curveFitter2 = new CurveFitter<ParametricUnivariateFunction>(optimizer);
        curveFitter2.addObservedPoint( 15,  4453);
        curveFitter2.addObservedPoint( 31,  8503);
        curveFitter2.addObservedPoint( 62, 17596);
        curveFitter2.addObservedPoint(125, 30592);
        curveFitter2.addObservedPoint(250, 45097);
        curveFitter2.addObservedPoint(500, 50693);


        curveFitter2.fit(function, guess);

    }

    public static void main(String[] args) {
        CustomizeCurveFitterTest simpleCurveFitterDemo = new CustomizeCurveFitterTest();
        simpleCurveFitterDemo.curveFitter();
    }
}
