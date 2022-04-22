package com.ppq.controller;

import com.ppq.dto.ResponseCode;
import com.ppq.pojo.CustomerMember;
import com.ppq.service.CustomerMemberService;
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
@RequestMapping(value = "/member")
public class CustomerMemberController {
    @Autowired
    @Qualifier("CustomerMemberServiceImpl")
    private CustomerMemberService customerMemberService;


    /**
     * 跳转到新增客户页
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        return "views/customer/member/insert";
    }
    /**
     * 新增客户
     *
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode insert(CustomerMember customerMember) {
        int count = customerMemberService.insertSelective(customerMember);
        if (count > 0) {
            return new ResponseCode(200, "新增会员等级成功", null);
        }
        return new ResponseCode(500, "新增会员等级失败，请检查数据", null);
    }


    /**
     * 跳转到更新客户页
     *
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("memberId") int memberId, Model model) {
        CustomerMember customerMember = customerMemberService.selectByPrimaryKey(memberId);

        model.addAttribute("customerMember", customerMember);
        return "views/customer/member/update";
    }

    /**
     * 更新客户
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode update(CustomerMember customerMember) {
        int count = customerMemberService.updateByPrimaryKeySelective(customerMember);
        if (count > 0) {
            return new ResponseCode(200, "更新会员等级成功", null);
        }
        return new ResponseCode(500, "更新会员等级失败，请检查数据", null);
    }

    /**
     * 删除客户
     *
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseCode delete(@RequestParam("memberId") int memberId) {
        int count = customerMemberService.deleteByPrimaryKey(memberId);
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
    public String list(Model model) {

        List<CustomerMember> list = customerMemberService.selectAllCustomer();
        model.addAttribute("memberList", list);
        return "views/customer/member/manage";
    }
}
