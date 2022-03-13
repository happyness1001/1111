package ln.dlut.ln.controller;

import ln.dao.OrderDao;
import ln.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ln.pojo.Info;
import ln.pojo.Order;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDao orderDao;


    public Order getOrderFromCenter(Info info){
        System.out.println("解析info，生成order");
        Order order = new Order();
        return order;
    };//从中台接收订单信息 并解析之后生成运单

@RequestMapping("map")
public String map(){
    return "GeoCode";
    }


    @RequestMapping("/match")
    public String match(Model model) {

//        orderService.match(getOrderFromCenter(info));  获得中台传过来的信息，生成order
        Order order = orderDao.getOrderByID("1");
        orderService.match(order);
        model.addAttribute("order",order);
        System.out.println("已确认收货，跳转页面");
        return "map";
    }
    @RequestMapping("toMatch")
    public String toMatch(Model model){
        Order order = orderDao.getOrderByID("1");
        model.addAttribute("q_order",order);
        return "orderUpdate";
    }

}
