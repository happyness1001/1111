package com.ppq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ppq.dto.ResponseCode;
import com.ppq.pojo.ItemCategory;
import com.ppq.pojo.SupplyRecord;
import com.ppq.service.ItemCategoryService;
import com.ppq.service.SupplyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/supplier")
public class SupplyRecordController {
    @Autowired
    @Qualifier("SupplyRecordServiceImpl")
    private SupplyRecordService supplyRecordService;

    @Autowired
    @Qualifier("ItemCategoryServiceImpl")
    private ItemCategoryService itemCategoryService;

    /**
     *
     *
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam("category") String category, Model model) {
        String[] s = category.split(" ");
        List<SupplyRecord> list = supplyRecordService.selectSupplyRecordByCategory(s[0]);
        PageHelper.startPage(pn, 10);
        model.addAttribute("pageInfo", new PageInfo<>(list));
        model.addAttribute("category", s[0]);
        return "views/supplier/recommend";
    }
    /**
     * 跳转页面
     */
    @RequestMapping(value = "/recommend", method = RequestMethod.GET)
    public String recommend() {
        return "views/supplier/recommend";
    }

    /**
     *模糊查询
     *
     */
    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    @ResponseBody
    public String[] recommend(String category) {
        System.out.println(category);
        List<ItemCategory> itemCategory = itemCategoryService.fuzzyQueryByNumber(category + "%");
        String[] str = new String[itemCategory.size()];
        for (int i = 0; i < (str.length > 10 ? 10 : str.length); i++) {
            str[i] = itemCategory.get(i).getCategoryNumber() + " " + itemCategory.get(i).getCategoryName();
        }
        return str;
    }
    /**
     * 跳转到新增客户页
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        return "views/supplier/insert";
    }
    /**
     * 新增客户
     *
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode insert(SupplyRecord supplyRecord) {
        int count = supplyRecordService.insertSelective(supplyRecord);
        if (count > 0) {
            return new ResponseCode(200, "新增供货记录成功", null);
        }
        return new ResponseCode(500, "新增供货记录失败，请检查数据", null);
    }


    /**
     * 跳转到更新页
     *
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("recordId") int recordId, Model model) {
        SupplyRecord supplyRecord = supplyRecordService.selectByPrimaryKey(recordId);
        model.addAttribute("supplyRecord", supplyRecord);
        return "views/supplier/update";
    }

    /**
     * 更新客户
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode update(SupplyRecord supplyRecord) {
        int count = supplyRecordService.updateByPrimaryKeySelective(supplyRecord);
        if (count > 0) {
            return new ResponseCode(200, "更新供货记录成功", null);
        }
        return new ResponseCode(500, "更新供货记录失败，请检查数据", null);
    }

    /**
     * 删除
     *
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseCode delete(@RequestParam("recordId") int recordId) {
        int count = supplyRecordService.deleteByPrimaryKey(recordId);
        if (count > 0) {
            return new ResponseCode(200, "删除供货记录成功",null);
        }
        return new ResponseCode(200, "删除供货记录失败，请检查数据",null);
    }
    /**
     * 查询
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

        PageHelper.startPage(pn, 10);
        List<SupplyRecord> list = supplyRecordService.selectAllSupplyRecord();
        model.addAttribute("pageInfo", new PageInfo<>(list));
        return "views/supplier/manage";
    }
}
