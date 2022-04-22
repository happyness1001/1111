package com.ppq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ppq.dto.ResponseCode;
import com.ppq.pojo.AssociationRules;
import com.ppq.pojo.Transaction;
import com.ppq.service.AssociationRulesService;
import com.ppq.service.ItemCategoryService;
import com.ppq.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/AssociationAnalysis")
public class AssociationAnalysisController {
    @Autowired
    @Qualifier("TransactionServiceImpl")
    private TransactionService transactionService;
    @Autowired
    @Qualifier("ItemCategoryServiceImpl")
    private ItemCategoryService itemCategoryService;
    @Autowired
    @Qualifier("AssociationRulesServiceImpl")
    private AssociationRulesService associationRulesService;
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
        List<Transaction> list = transactionService.selectTransaction();
        model.addAttribute("pageInfo", new PageInfo<>(list));
        return "views/association/data";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("level") int level, @RequestParam("beginDate") String beginDate,
                         @RequestParam("support") double support,@RequestParam("confidence") double confidence,
                         @RequestParam("endDate") String endDate,@RequestParam(value = "pn", defaultValue = "1") Integer pn,Model model) {
        //这个map中存有关联规则以及关联规则的置信度
        PageHelper.startPage(pn, 10);
        Map<List<String>, Double> map = transactionService.selectNumberGroupById(beginDate, endDate, level, support, confidence);
        List<AssociationRules> associationRules = itemCategoryService.getAssociationRules(map);
        model.addAttribute("pageInfo", new PageInfo<>(associationRules));
        return "views/association/rules";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(@RequestParam("preItemNumber") String preItemNumber, @RequestParam("preItemName") String preItemName,
                               @RequestParam("postItemNumber") String postItemNumber, @RequestParam("postItemName") String postItemName,
                               @RequestParam("confidence") double confidence) {
        associationRulesService.addRules(new AssociationRules(1,preItemNumber, preItemName, postItemNumber, postItemName, confidence));
        return "views/association/rules";
    }
    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String manage(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 10);
        List<AssociationRules> list = associationRulesService.selectRules();
        model.addAttribute("pageInfo", new PageInfo<>(list));
        return "views/association/manage";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseCode delete(@RequestParam("rulesId") int rulesId) {
        int count = associationRulesService.deleteRules(rulesId);
        if (count > 0) {
            return new ResponseCode(200, "删除成功",null);
        }
        return new ResponseCode(200, "删除失败，请检查数据",null);
    }
}
