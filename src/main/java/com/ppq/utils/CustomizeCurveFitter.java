package com.ppq.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.fitting.CurveFitter;
import org.apache.commons.math3.fitting.SimpleCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomizeCurveFitter {
    //因为多项式中有一个不定量 key为时段  value为对应时段的情绪指数
    private Map<Double, Double> WMap;
//    //市场潜量
//    private double m;
//    //创新系数
//    private double p;
//    //最大模仿系数
//    private double a;
//    //最小模仿系数
//    private double b;
//    //常数
//    private double c;
    //拟合数据点
    private Map<Double, Double> points;

    class MyFunction implements ParametricUnivariateFunction {
        //计算函数的值。
        public double value(double x, double ... parameters) {
            //市场潜量
            double m = parameters[0];
            //创新系数
            double p = parameters[1];
            //最大模仿系数
            double a = parameters[2];
            //最小模仿系数
            double b = parameters[3];
            //常数
            double c = parameters[4];
            //模仿系数q
            //return m*((1-Math.exp(-(p+q)*x))/(1+q/p*Math.exp(-(p+q)*x)));
            double w = WMap.get(x);
            //double q=a*b/(b+(a-b)*Math.exp(-c*w));
            double q=a*b*Math.exp(c*w)/(b*Math.exp(c*w)+a-b);
            return m*((p*Math.exp((p+q)*x)-p)/(p* Math.exp((p+q)*x)+q));

        }
        //计算函数相对于其参数的梯度。
        public double[] gradient(double x, double ... parameters) {
            //市场潜量
            double m = parameters[0];
            //创新系数
            double p = parameters[1];
            //最大模仿系数
            double a = parameters[2];
            //最小模仿系数
            double b = parameters[3];
            //常数
            double c = parameters[4];

            double[] gradients = new double[5];

            double w = WMap.get(x);
            double q=a*b*Math.exp(c*w)/(b*Math.exp(c*w)+a-b);
            //方便求导
            double den = Math.exp((p+q)*x);
            double den2 = Math.exp(c*w);

            gradients[0] = (p*den-p)/(p*den+q); // 对 m 求导
            gradients[1] = m*(((p*q+p*p)*x+q)*den-q)/(p*p*den*den+2*p*q*den+q*q); // 对 p 求导
            gradients[2] = m*(((p*q+p*p)*x-p)*den+p)/(p*p*den*den+2*p*q*den+q*q)*((b*den2*(b*den2+a-b)-a*b*den2)/(Math.pow(b*den2+a-b,2))); // 对 a 求导
            gradients[3] = m*(((p*q+p*p)*x-p)*den+p)/(p*p*den*den+2*p*q*den+q*q)*((a*den2*(b*den2+a-b)-a*b*den2*(den2-1))/(Math.pow(b*den2+a-b,2))); // 对 b 求导
            gradients[4] = m*(((p*q+p*p)*x-p)*den+p)/(p*p*den*den+2*p*q*den+q*q)*((w*a*b*den2*(b*den2+a-b)-a*b*den2*(b*w*den2))/(Math.pow(b*den2+a-b,2))); // 对 c 求导
            return gradients;
        }
    }
    public double[] curveFitter() {
        ParametricUnivariateFunction function = new MyFunction();/*多项式函数*/
        double[] guess = {points.get(points.size()+0.0), 0.05, 1, 0.5, 0}; /*猜测值 依次为 m p a,b,c 。必须和 gradient 方法返回数组对应*/
        // 初始化拟合
        SimpleCurveFitter curveFitter = SimpleCurveFitter.create(function,guess);
        // 添加数据点。带权重的点，我的理解这个点权重越大，拟合出来的曲线会更靠近这个点
        WeightedObservedPoints observedPoints = new WeightedObservedPoints();
        for (double i = 1.0; i < points.size()+1.0; i+=1.0) {
            observedPoints.add(i,points.get(i));
        }
        /*
         * best 为拟合结果 对应 a b c d
         * 可能会出现无法拟合的情况
         * 需要合理设置初始值
         * */
        return curveFitter.fit(observedPoints.toList());
    }
    public List<Double> getForecast(Map<Double,Double> points,Map<Double,Double> map){
        CustomizeCurveFitter simpleCurveFitterDemo = new CustomizeCurveFitter();
        List<Double> list = new ArrayList<>();
        simpleCurveFitterDemo.setPoints(points);
        simpleCurveFitterDemo.setWMap(map);
        double[] best = simpleCurveFitterDemo.curveFitter();
        System.out.println(Arrays.toString(best));
        double m = best[0];
        double p = best[1];
        double a = best[2];
        double b = best[3];
        double c = best[4];
        double w,q,x,result = 0;
        //拟合值
        for (int i = 1; i < points.size()+1; i++) {
            w = simpleCurveFitterDemo.getWMap().get((double)i);
            q = a*b*Math.exp(c*w)/(b*Math.exp(c*w)+a-b);
            x = i;
            result = m*((p*Math.exp((p+q)*x)-p)/(p* Math.exp((p+q)*x)+q));
            list.add((double)Math.round(result*100)/100);
        }
        //预测值
        for (int i = 0; i < 3; i++) {
            simpleCurveFitterDemo.setPoints(points);
            simpleCurveFitterDemo.setWMap(map);
            best = simpleCurveFitterDemo.curveFitter();
            m = best[0];
            p = best[1];
            a = best[2];
            b = best[3];
            c = best[4];
            w = simpleCurveFitterDemo.getWMap().get((double)simpleCurveFitterDemo.getPoints().size()-i);
            q=a*b*Math.exp(c*w)/(b*Math.exp(c*w)+a-b);
            x = simpleCurveFitterDemo.getPoints().size()+i+1;
            result = m*((p*Math.exp((p+q)*x)-p)/(p* Math.exp((p+q)*x)+q));
            list.add((double)Math.round(result*100)/100);
            //把预测值加入集合,再拟合,再预测下一个时段的累计销量
            points.put(points.size()+1.0,result);
            map.put(map.size()+1.0,map.get(map.size()+0.0));
        }
        return list;
    }
}
