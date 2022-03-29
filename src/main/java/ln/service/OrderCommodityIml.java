package ln.service;

import ln.dao.CommodityDao;
import ln.dao.OrderCommodityDao;
import ln.pojo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCommodityIml implements OrderCommodityService {
    @Autowired
    @Qualifier("orderCommodityDao")
    private OrderCommodityDao orderCommodityDao;
    @Autowired
    @Qualifier("commodityDao")
    private CommodityDao commodityDao;

    @Override
    public boolean isShipped(String orderId) {
        return getCommodityByOrder(orderId).getStatus() == 4;
    }

    @Override
    public boolean isArrive(String orderId) {
        return getCommodityByOrder(orderId).getStatus() == 5;
    }

    @Override
    public boolean isSigned(String orderId) {
        return getCommodityByOrder(orderId).getStatus() == 6;
    }


    private Commodity getCommodityByOrder(String orderId) {

        List<String> commodities = orderCommodityDao.get_by_order(orderId);
        assert commodities != null : "没有该订单";
        System.out.println("commodities:" + commodities);
        String commodityId = commodities.get(0);
        return commodityDao.getCommodityByID(commodityId);
    }
}
