package com.ppq.utils;

import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.fitting.CurveFitter;
import org.apache.commons.math3.fitting.SimpleCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer;

import java.util.Arrays;

public class CustomizeCurveFitterDemo {
    class MyFunction implements ParametricUnivariateFunction {
        //计算函数的值。
        public double value(double x, double ... parameters) {
//            double a = parameters[0];
//            double b = parameters[1];
//            double c = parameters[2];
//            double d = parameters[3];
//
//            return d + ((a - d) / (1 + Math.pow(x / c, b)));
            double m = parameters[0];
            double p = parameters[1];
            double q = parameters[2];
            //return m*((1-Math.exp(-(p+q)*x))/(1+q/p*Math.exp(-(p+q)*x)));

            return m*((p* Math.exp((p+q)*x)-p)/(p* Math.exp((p+q)*x)+q));

        }
        //计算函数相对于其参数的梯度。
        public double[] gradient(double x, double ... parameters) {
//            double a = parameters[0];
//            double b = parameters[1];
//            double c = parameters[2];
//            double d = parameters[3];
//
//            double[] gradients = new double[4];
//            double den = 1 + Math.pow(x / c, b);
//
//            gradients[0] = 1 / den; // 对 a 求导
//
//            gradients[1] = -((a - d) * Math.pow(x / c, b) * Math.log(x / c)) / (den * den); // 对 b 求导
//
//            gradients[2] = (b * Math.pow(x / c, b - 1) * (x / (c * c)) * (a - d)) / (den * den); // 对 c 求导
//
//            gradients[3] = 1 - (1 / den); // 对 d 求导
//
//            return gradients;
            double m = parameters[0];
            double p = parameters[1];
            double q = parameters[2];

            double[] gradients = new double[3];
            //double den = Math.exp(-(p+q)*x);
            double den = Math.exp((p+q)*x);
            //gradients[0] = (1 - den)/(1+q/p*den); // 对 m 求导
            //gradients[1] = m*(x*den*(1+q/p*den)+q*den*(1-den)/Math.pow(p,2)*(1+p*x))/Math.pow(1+q/p*den,2); // 对 p 求导
            //gradients[2] = m*(x*den*(1+q/p*den)+(1-den)*den/p*(1-q*x))/Math.pow(1+q/p*den,2); // 对 q 求导

            gradients[0] = (p*den-p)/(p*den+q); // 对 m 求导
            gradients[1] = m*(((p*q+p*p)*x+q)*den-q)/(p*p*den*den+2*p*q*den+q*q); // 对 p 求导
            gradients[2] = m*(((p*q+p*p)*x-p)*den+p)/(p*p*den*den+2*p*q*den+q*q); // 对 q 求导
            return gradients;
        }
    }

    ParametricUnivariateFunction function = new MyFunction();
    // 生成待拟合数据
    public double[][] getPoints(ParametricUnivariateFunction function,double[] value) {
//        double[][] xy = new double[6][2];
//        xy[0] = new double[]{15, 4443};
//        xy[1] = new double[]{31, 8493};
//        xy[2] = new double[]{62, 17586};
//        xy[3] = new double[]{125, 30582};
//        xy[4] = new double[]{250, 45087};
//        xy[5] = new double[]{500, 50683};
//        return xy;

//        double[][] xy = new double[9][2];
//        xy[0] = new double[]{1, 275};
//        xy[1] = new double[]{2, 738};
//        xy[2] = new double[]{3, 1336};
//        xy[3] = new double[]{4, 2338};
//        xy[4] = new double[]{5, 3229};
//        xy[5] = new double[]{6, 3862};
//        xy[6] = new double[]{7, 4107};
//        xy[7] = new double[]{8, 4373};
//        xy[8] = new double[]{9, 4485};

        double[][] xy = new double[11][2];
        xy[0] = new double[]{1, 22};
        xy[1] = new double[]{2, 68};
        xy[2] = new double[]{3, 93};
        xy[3] = new double[]{4, 147};
        xy[4] = new double[]{5, 219};
        xy[5] = new double[]{6, 267};
        xy[6] = new double[]{7, 315};
        xy[7] = new double[]{8, 384};
        xy[8] = new double[]{9, 419};
        xy[9] = new double[]{10, 452};
        xy[10] = new double[]{11, 493};
        return xy;
    }

    public void curveFitter() {
        ParametricUnivariateFunction function = new MyFunction();/*多项式函数*/
        //double[] guess = {1500, 0.95, 65, 35000}; /*猜测值 依次为 a b c d 。必须和 gradient 方法返回数组对应*/
        double[] guess = {500, 1, 1}; /*猜测值 依次为 m p q 。必须和 gradient 方法返回数组对应*/
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
//        curveFitter2.addObservedPoint( 15,  4443);
//        curveFitter2.addObservedPoint( 31,  8493);
//        curveFitter2.addObservedPoint( 62, 17586);
//        curveFitter2.addObservedPoint(125, 30582);
//        curveFitter2.addObservedPoint(250, 45087);
//        curveFitter2.addObservedPoint(500, 50683);



//        curveFitter2.addObservedPoint(1, 275);
//        curveFitter2.addObservedPoint(2, 738);
//        curveFitter2.addObservedPoint(3, 1336);
//        curveFitter2.addObservedPoint(4, 2338);
//        curveFitter2.addObservedPoint(5, 3229);
//        curveFitter2.addObservedPoint(6, 3862);
//        curveFitter2.addObservedPoint(7, 4107);
//        curveFitter2.addObservedPoint(8, 4373);
//        curveFitter2.addObservedPoint(9, 4485);


        curveFitter2.addObservedPoint(1, 22);
        curveFitter2.addObservedPoint(2, 68);
        curveFitter2.addObservedPoint(3, 93);
        curveFitter2.addObservedPoint(4, 147);
        curveFitter2.addObservedPoint(5, 219);
        curveFitter2.addObservedPoint(6, 267);
        curveFitter2.addObservedPoint(7, 315);
        curveFitter2.addObservedPoint(8, 384);
        curveFitter2.addObservedPoint(9, 419);
        curveFitter2.addObservedPoint(10, 452);
        curveFitter2.addObservedPoint(11, 493);

        curveFitter2.fit(function, guess);

    }

    public static void main(String[] args) {
        CustomizeCurveFitterDemo simpleCurveFitterDemo = new CustomizeCurveFitterDemo();
        simpleCurveFitterDemo.curveFitter();
    }
}
