package ln.service;

import ln.pojo.Commodity;
import ln.pojo.Order;

import java.util.List;

public interface OrderService {

    void match(Order order);//
    void change(Order order);
    int analyse(Order order);//分析订单
    String dispatch(String receive_location,String order_id);//分发订单
//    void addAddressDistance();

    //根据订单查询商品
    List<Commodity> getCommodityList(Order order);
    //逻辑：getInfo 获得订单信息，返回该订单，——> analyse 分析订单返回订单类型 ——> 获取收件地址，相应的商品信息， 将商品装车 ，同时将相应信息存储，等到
    //车满，利用算法生成路线，同时提供改变商品状态和查询状态的功能。
    //

}
