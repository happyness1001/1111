package com.ppq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ppq.dto.ResponseCode;
import com.ppq.pojo.MemberItem;
import com.ppq.service.MemberItemService;
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
@RequestMapping(value = "/memberItem")
public class MemberItemController {
    @Autowired
    @Qualifier("MemberItemServiceImpl")
    private MemberItemService memberItemService;


    /**
     * 跳转到新增客户页
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        return "views/customer/memberItem/insert";
    }
    /**
     * 新增客户
     *
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode insert(MemberItem memberItem) {
        int count = memberItemService.insertSelective(memberItem);
        if (count > 0) {
            return new ResponseCode(200, "新增会员商品成功", null);
        }
        return new ResponseCode(500, "新增会员商品失败，请检查数据", null);
    }


    /**
     * 跳转到更新客户页
     *
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("id") int id, Model model) {
        MemberItem memberItem = memberItemService.selectByPrimaryKey(id);

        model.addAttribute("memberItem", memberItem);
        return "views/customer/memberItem/update";
    }

    /**
     * 更新客户
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode update(MemberItem memberItem) {
        int count = memberItemService.updateByPrimaryKeySelective(memberItem);
        if (count > 0) {
            return new ResponseCode(200, "更新会员商品成功", null);
        }
        return new ResponseCode(500, "更新会员商品失败，请检查数据", null);
    }

    /**
     * 删除客户
     *
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseCode delete(@RequestParam("id") int id) {
        int count = memberItemService.deleteByPrimaryKey(id);
        if (count > 0) {
            return new ResponseCode(200, "删除成功",null);
        }
        return new ResponseCode(200, "删除失败，请检查数据",null);
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
        List<MemberItem> list = memberItemService.selectAllMemberItem();
        model.addAttribute("pageInfo", new PageInfo<>(list));
        return "views/customer/memberItem/manage";
    }
}
