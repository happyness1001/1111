package com.ppq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ppq.dto.ResponseCode;
import com.ppq.pojo.Customer;
import com.ppq.pojo.CustomerRecord;
import com.ppq.service.CustomerRecordService;
import com.ppq.service.CustomerService;
import com.ppq.service.CustomerTransactionService;
import com.ppq.utils.LinearRegressionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/customerTransaction")
public class CustomerTransactionController {
    @Autowired
    @Qualifier("CustomerTransactionServiceImpl")
    private CustomerTransactionService customerTransactionService;
    @Autowired
    @Qualifier("CustomerServiceImpl")
    private CustomerService customerService;
    @Qualifier("CustomerRecordServiceImpl")
    @Autowired
    private CustomerRecordService customerRecordService;
    /**
     * 分页查询
     *
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        return "views/customer/transaction/manage";
    }
    /**
     *
     *信息筛选
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("beginDate") String beginDate, @RequestParam("endDate") String endDate, @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) throws IOException {
        Map<Integer, double[][]> integerMap = customerTransactionService.selectAllOrderByDate(beginDate, endDate);
        //客户信息
        PageHelper.startPage(pn, 10);
        LinearRegressionUtil linearRegressionUtil = new LinearRegressionUtil();
        List<Customer> customerList = customerService.selectAllCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            if(integerMap.containsKey(customerList.get(i).getCustomerId())){
                customerList.get(i).setFrequency(Math.round(linearRegressionUtil.regression(integerMap.get(customerList.get(i).getCustomerId()))[1]*100)/100.0);
            }else{
                customerList.get(i).setFrequency(0);
            }
        }
        model.addAttribute("pageInfo", new PageInfo<>(customerList));
        model.addAttribute("beginDate", beginDate);
        model.addAttribute("endDate", endDate);
        return "views/customer/transaction/manage";
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("customerId") String customerId, @RequestParam("beginDate") String beginDate, @RequestParam("endDate") String endDate,Model model) {
        double[][] points = customerTransactionService.selectAllOrderByDate(beginDate, endDate).get(Integer.parseInt(customerId));
        System.out.println(points[1][1]);
        //实际累计销售量
        List<Double> realList = new ArrayList<>();
        //拟合出来的累计销售量
        List<Double> fittingList = new ArrayList<>();
        //x轴坐标
        List<Double> xAxis = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            xAxis.add(points[i][0]);
            realList.add(points[i][1]);
        }
        LinearRegressionUtil linearRegressionUtil = new LinearRegressionUtil();
        double b = linearRegressionUtil.regression(points)[0];
        double k = linearRegressionUtil.regression(points)[1];
        for (int i = 0; i < points.length; i++) {
            fittingList.add((double)Math.round((k*i+b)*100)/100);
        }
        model.addAttribute("realList", realList.toString());
        model.addAttribute("fittingList", fittingList.toString());
        model.addAttribute("xAxis", xAxis.toString());
        return "views/customer/transaction/detail";
    }
    @RequestMapping(value = "/record/search", method = RequestMethod.GET)
    public String record(@RequestParam("customerId") int customerId,Model model) {
        String record = customerRecordService.selectRecordByPrimaryKey(customerId);
        model.addAttribute("record", record);
        model.addAttribute("customerId", customerId);
        return "views/customer/transaction/record";
    }
    @RequestMapping(value = "/record/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode update(CustomerRecord customerRecord) {
        System.out.println(customerRecord.toString());
        int count = customerRecordService.updateByPrimaryKeySelective(customerRecord);
        if (count > 0) {
            return new ResponseCode(200, "更新回访记录成功", null);
        }
        return new ResponseCode(500, "更新回访记录失败，请检查数据", null);
    }
}
