package com.ppq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ppq.pojo.Comment;
import com.ppq.pojo.ResultMap;
import com.ppq.service.CommentService;
import com.ppq.utils.CommentSentimentAnalysis;
import com.ppq.utils.CustomizeCurveFitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/bassCalculate")
public class BassModelController {

    @Autowired
    @Qualifier("CommentServiceImpl")
    private CommentService commentService;
    /**
     * 分页查询
     *
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        return "views/analysis/data";
    }
    /**
     *
     *评论筛选
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("id") String id, @RequestParam("beginDate") String beginDate, @RequestParam("endDate") String endDate,@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) throws IOException {
        PageHelper.startPage(pn, 10);
        List<Comment> list = commentService.queryCommentByIdAndDate(id,beginDate,endDate);
        CommentSentimentAnalysis analysis = new CommentSentimentAnalysis();
        //分析每条评论内容正面的可能性
        list = analysis.setAnalysisResult(list);
        model.addAttribute("pageInfo", new PageInfo<>(list));
        model.addAttribute("id", id);
        model.addAttribute("beginDate", beginDate);
        model.addAttribute("endDate", endDate);
        return "views/analysis/data";
    }
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public String chart(@RequestParam("id") String id, @RequestParam("beginDate") String beginDate, @RequestParam("endDate") String endDate,@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) throws IOException {
        System.out.println(id+beginDate+endDate);
        //实际累计销售量
        List<Double> realList = new ArrayList<>();
        //真实数据点的集合
        Map<Double,Double> points = new HashMap<>();
        //每个时间段对应情绪值
        Map<Double,Double> map = new HashMap<>();
        //拟合出来的累计销售量
        List<Double> fittingList = new ArrayList<>();
        //预测出来的累计销售量
        //List<Double> forecastList = new ArrayList<>();
        //预测的时段
        List<String> forecastDate = new ArrayList<>();
        //x轴坐标
        List<Integer> xAxis = new ArrayList<>();
        //累加
        int sum = 0;
        //每周情感指数的总分
        double score = 0.0;
        CommentSentimentAnalysis analysis = new CommentSentimentAnalysis();
        List<ResultMap> resultMaps = commentService.countCommentByIdAndDate(id, beginDate, endDate);
        //真实数据
        //将从数据库中查到的值给realList(掐头去尾)
        for (int i = 1; i < resultMaps.size()-1; i++) {
            sum += resultMaps.get(i).getCounts();
            realList.add((double)sum);
        }
        //x轴坐标赋值
        for (int i = 1; i < resultMaps.size()-1; i++) {
            xAxis.add(i);
        }
        //真实数据点的集合
        for (double i = 0; i < realList.size(); i += 1.0) {
            points.put(i+1.0,realList.get((int)i));
        }
        //按周查询多条评论
        for (int i = 1; i < resultMaps.size()-1; i++) {
            String week = resultMaps.get(i).getWeeks().substring(5, 7);
            List<String> list = commentService.queryCommentByIdAndDateAndWeek(id, beginDate, endDate, week);
            //每条评论对应的情绪指数
            List<Double> analysisResult = analysis.getAnalysisResult(list);
            for (Double aDouble : analysisResult) {
                score += aDouble > 50 ? aDouble : -5*(100-aDouble);
            }
            map.put(i+0.0,(double)Math.round(score/list.size()*100)/100);
            score = 0;
        }
        //System.out.println(map.toString());
        CustomizeCurveFitter curveFitter = new CustomizeCurveFitter();
        //拟合数据
        fittingList = curveFitter.getForecast(points,map);
        //预测时段
        String str = resultMaps.get(resultMaps.size()-1).getWeeks().substring(0,5);
        int week = Integer.parseInt(resultMaps.get(resultMaps.size()-1).getWeeks().substring(5,7));
        for (int i = 0; i < 3; i++) {
            int week1 = week+i;
            forecastDate.add(str+week1);
        }
        model.addAttribute("realList", realList.toString());
        model.addAttribute("fittingList", fittingList.subList(0,realList.size()).toString());
        model.addAttribute("forecastDate",forecastDate);
        model.addAttribute("forecastList", fittingList.subList(realList.size(),fittingList.size()));
        model.addAttribute("xAxis", xAxis.toString());
        model.addAttribute("id", id);
        model.addAttribute("beginDate", beginDate);
        model.addAttribute("endDate", endDate);
        return "views/analysis/chart";
    }
}

