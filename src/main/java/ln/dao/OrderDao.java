package ln.dao;

import ln.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {


    //查询全部订单
    List<Order> getOrderList();

    //根据ID查询订单
    Order getOrderByID(String id);

    //插入新的订单
    int addOrder(Order order);

    //修改订单信息
    int updateOrder(Order order);

    //删除订单信息
    int deleteOrder(String id);

}
