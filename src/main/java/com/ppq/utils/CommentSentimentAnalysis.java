package com.ppq.utils;

import com.hankcs.hanlp.classification.classifiers.IClassifier;
import com.hankcs.hanlp.classification.classifiers.NaiveBayesClassifier;
import com.hankcs.hanlp.classification.models.NaiveBayesModel;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.ppq.pojo.Comment;
import com.ppq.service.CommentService;
import com.ppq.service.SentimentAnalysisService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentSentimentAnalysis {

    public static final String MODEL_PATH = "F:\\研究生资料\\潘佩琦\\毕设\\框架\\CRM\\data\\test\\classification-model.ser";
    /*
     * @author ppq
     * @date 2021/2/15 23:07
     * @param [content] 评论的内容
     * @return  评论内容正面的概率
     */
    public List<Comment> setAnalysisResult(List<Comment> comment) throws IOException {
        //加载训练好的模型
        IClassifier classifier = new NaiveBayesClassifier(loadModel());
        for (Comment comment1 : comment) {
            comment1.setPositiveProbability((double) Math.round(predict(classifier,comment1.getContent()).get("正面")*10000)/100);
        }
        return comment;
    }
    //查询多条评论内容积极的概率
    public List<Double> getAnalysisResult(List<String> contentList) throws IOException {
        //加载训练好的模型
        IClassifier classifier = new NaiveBayesClassifier(loadModel());
        List<Double> resultList = new ArrayList<>();
        for (String s : contentList) {
            resultList.add((double) Math.round(predict(classifier,s).get("正面")*10000)/100);
        }
        return resultList;
    }
    private static Map<String, Double> predict(IClassifier classifier, String text)
    {
        return classifier.predict(text);
    }

    private static NaiveBayesModel loadModel() throws IOException
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CommentService commentServiceImpl = (CommentService)context.getBean("CommentServiceImpl");
        NaiveBayesModel model = (NaiveBayesModel) IOUtil.readObjectFrom(MODEL_PATH);
        return model;

    }
    public void trainModel(Map<String, String[]> map){
        IClassifier classifier = new NaiveBayesClassifier();// 创建分类器，更高级的功能请参考IClassifier的接口定义
        classifier.train(map);// 训练后的模型支持持久化，下次就不必训练了
        NaiveBayesModel model = (NaiveBayesModel) classifier.getModel();
        IOUtil.saveObjectTo(model, MODEL_PATH);
    }
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CommentService commentServiceImpl = (CommentService)context.getBean("CommentServiceImpl");
        Map<String, String[]> map = new HashMap<>();
        map.put("正面",(String[]) commentServiceImpl.queryAllPositiveContent().toArray(new String[0]));
        map.put("负面",(String[]) commentServiceImpl.queryAllNegativeContent().toArray(new String[0]));
        IClassifier classifier = new NaiveBayesClassifier();
        classifier.train(map);
        NaiveBayesModel model = (NaiveBayesModel) classifier.getModel();
        IOUtil.saveObjectTo(model, MODEL_PATH);
    }
    @Test
    public void test6() throws IOException {
        IClassifier classifier = new NaiveBayesClassifier(loadModel());
        System.out.println(classifier.predict("买后第二天就涨价了").get("正面"));
    }
    @Test
    public void test7() throws IOException {
        IClassifier classifier = new NaiveBayesClassifier(loadModel());
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CommentService commentServiceImpl = (CommentService)context.getBean("CommentServiceImpl");
        List<Comment> list = commentServiceImpl.queryCommentByIdAndDate("012510020001","2020-10-01","2020-12-01");
        //CommentSentimentAnalysis analysis = new CommentSentimentAnalysis();
        //分析每条评论内容正面的可能性
        for (Comment comment : list) {
            //predict(classifier,comment.getContent()).get("正面")
            comment.setPositiveProbability((double) Math.round(predict(classifier,comment.getContent()).get("正面")*10000)/100);
            //comment.setPositiveProbability((double) Math.round(analysis.getAnalysisResult(comment.getContent())*10000)/10000);
        }
        for (Comment comment : list) {
            System.out.println(comment.getPositiveProbability());
        }
    }
    @Test
    public void test9() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SentimentAnalysisService sentimentAnalysisImpl = (SentimentAnalysisService)context.getBean("SentimentAnalysisImpl");
        Map<String, String[]> map = new HashMap<>();
        map.put("正面",sentimentAnalysisImpl.queryAllPositiveContent().toArray(new String[0]));
        map.put("负面",sentimentAnalysisImpl.queryAllNegativeContent().toArray(new String[0]));
        trainModel(map);

    }
}
