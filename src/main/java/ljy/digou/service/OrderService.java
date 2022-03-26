package ljy.digou.service;

import ljy.digou.pojo.Order;
import ljy.digou.pojo.OrderItem;

import java.util.List;

public interface OrderService {

    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";
    String waitTuihuo = "waitTuihuo";
    String yituihuo = "yituihuo";

    void add(Order c);

    float add(Order c, List<OrderItem> ois);

    void delete(int id);

    void update(Order c);

    Order get(int id);

    List list();

    List list(int uid, String excludedStatus);


    //自定义　供后台管理员进行　查看历史订单未发货订单
    List list_By_Admin(String status);

}
