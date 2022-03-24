package ln.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderCommodityDao {
    //通过订单id获得该订单的所有商品
    List<String> get_by_order(String order_id);
    //通过商品id获得某笔订单
    String get_by_commodity(String commodity_id);
    //插入新的关系
    String insert(String order_id,String commodity_id);
    //修改订单或者商品的信息
    String update(String order_id,String commodity_id);
    //删除该订单中的某个商品
    String delete_by_commodity(String commodity_id);
    //删除该订单得所有商品
    String delete_by_order(String order_id);
}
