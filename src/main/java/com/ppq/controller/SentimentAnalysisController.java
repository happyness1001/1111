package com.ppq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ppq.dto.ResponseCode;
import com.ppq.pojo.SentimentAnalysis;
import com.ppq.service.SentimentAnalysisService;
import com.ppq.utils.CommentSentimentAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/sentimentAnalysis")
public class SentimentAnalysisController {
    @Autowired
    @Qualifier("SentimentAnalysisImpl")
    private SentimentAnalysisService sentimentAnalysisService;

    /**
     * 训练模型
     */
    @RequestMapping(value = "/train")
    public void train() {
        Map<String, String[]> map = new HashMap<>();
        map.put("正面",sentimentAnalysisService.queryAllPositiveContent().toArray(new String[0]));
        map.put("负面",sentimentAnalysisService.queryAllNegativeContent().toArray(new String[0]));
        CommentSentimentAnalysis analysis = new CommentSentimentAnalysis();
        analysis.trainModel(map);
    }

    /**
     * 跳转到新增客户页
     *
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        return "views/analysis/setInsert";
    }

    /**
     * 新增客户
     *
     * @param sentimentAnalysis
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode insert(SentimentAnalysis sentimentAnalysis) {
        //首先查询插入的文本内容是否已存在数据库中,如果存在,插入失败.
        int count = sentimentAnalysisService.selectByText(sentimentAnalysis.getText());
        if (count > 0) {
            return new ResponseCode(500, "更新文本失败，文本内容已存在", null);
        }
        int count1 = sentimentAnalysisService.insertSelective(sentimentAnalysis);
        if (count1 > 0) {
            return new ResponseCode(200, "新增文本成功", null);
        }
        return new ResponseCode(500, "新增文本失败，请检查数据", null);
    }
    /**
     * 删除客户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseCode delete(@RequestParam("id") int id) {
        int count = sentimentAnalysisService.deleteByPrimaryKey(id);
        if (count > 0) {
            return new ResponseCode(200, "删除成功",null);
        }
        return new ResponseCode(200, "删除失败，请检查数据",null);
    }

    /**
     * 跳转到更新文本页
     *
     * @param textId
     * @param model
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("textId") int textId, Model model) {
        SentimentAnalysis sentimentAnalysis = sentimentAnalysisService.selectByPrimaryKey(textId);
        model.addAttribute("sentimentAnalysis", sentimentAnalysis);
        return "views/analysis/setUpdate";
    }
    /**
     * 更新文本
     *
     * @param sentimentAnalysis
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseCode update(SentimentAnalysis sentimentAnalysis) {
        //首先查询更新的文本内容是否已存在数据库中,如果存在,更新失败.
        int count = sentimentAnalysisService.selectByText(sentimentAnalysis.getText());
        if (count > 0) {
            return new ResponseCode(500, "更新文本失败，文本内容已存在", null);
        }
        int count1 = sentimentAnalysisService.updateByPrimaryKeySelective(sentimentAnalysis);
        if (count1 > 0) {
            return new ResponseCode(200, "更新文本成功", null);
        }
        return new ResponseCode(500, "更新文本失败，文本内容已存在", null);
    }
    /**
     * 分页查询
     *
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

        PageHelper.startPage(pn, 10);
        List<SentimentAnalysis> list = sentimentAnalysisService.selectAll();
        model.addAttribute("pageInfo", new PageInfo<>(list));
        return "views/analysis/setManage";
    }
}
