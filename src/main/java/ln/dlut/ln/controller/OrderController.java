package ln.dlut.ln.controller;

import ln.dao.OrderDao;
import ln.service.OrderIml;
import ln.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ln.pojo.Order;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    @Qualifier("orderIml")
    private OrderService orderService;
    @Autowired
    @Qualifier("orderDao")
    private OrderDao orderDao;
//    private OrderDao orderDao = new O


    public void getOrderFromCenter(gsh.pojo.Logistics info){
        System.out.println("解析info，生成order");

        Order order = new Order(info.getOrderId(),2,"ddd",info.getDeliverAddress().getReceiver_address(),"111",info.getDeliverAddress().getReceiver_phone(),"15",15);
        match(order);
    }//从中台接收订单信息 并解析之后生成运单

@RequestMapping("map")
public String map(){
    return "storage/GeoCode";
    }


    @RequestMapping("/match")
    public String match(Order order) {
//        order.getOrder_id()
//        orderService.match(getOrderFromCenter(info));  获得中台传过来的信息，生成order
//         order = orderDao.getOrderByID("1");
        orderService.match(order);
//        model.addAttribute("order",order);
        System.out.println("已确认收货，跳转页面");
        return "storage/map";
    }
    @RequestMapping("toMatch")
    public String toMatch(Model model){
        Order order = orderDao.getOrderByID("1");
        model.addAttribute("q_order",order);
        return "storage/orderUpdate";
    }

}
