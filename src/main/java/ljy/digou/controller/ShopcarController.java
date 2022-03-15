package ljy.digou.controller;

import ljy.digou.pojo.OrderItem;
import ljy.digou.pojo.Product;
import ljy.digou.pojo.User;
import ljy.digou.service.OrderItemService;
import ljy.digou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class ShopcarController {

    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ProductService productService;

    //显示所有购物车内容
    @RequestMapping("forecart")
    public String cart(Model model, HttpSession session) {
        User user =(User)  session.getAttribute("user");
        //获取购物车所有商品
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }

    //添加商品进购物车
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        //获取商品
        Product p = productService.get(pid);
        //获取用户
        User user =(User)  session.getAttribute("user");
        //购物车中是否存在此商品
        boolean found = false;
        //根据用户id得到购物车数据
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        //如果是购物车内的商品，将数量update
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
        //如果不是不是购物车中的商品，update购物车数据
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }

    //购物车中商品删除
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user = (User)session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }

    //修改购物车中商品数量
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
        }
        return "success";
    }


}
