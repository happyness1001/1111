package ln.service;


import ln.dao.CommodityDao;
import ln.dao.StoreHouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ln.pojo.Commodity;

import java.util.List;

@Service
public class CommodityIml implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private StoreHouseDao storeHouseDao;

    public void setCommodityDao(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    @Override
    public List<Commodity> getCommodityList() {
        return commodityDao.getCommodityList();
    }

    @Override
    public Commodity getCommodityByID(String commodity_id) {
        return commodityDao.getCommodityByID(commodity_id);
    }

    @Override
    public void addCommodity(Commodity commodity) {
        commodity.setCommodity_id(GenerateID());
//        if (storeHouseDao.getStoreHouseByID())
        commodityDao.addCommodity(commodity);
    }

    @Override
    public void updateCommodity(Commodity commodity) {
        commodityDao.updateCommodity(commodity);
    }

    @Override
    public void deleteCommodity(String commodity_id) {
//        int store_id = commodityDao.getCommodityByID(commodity_id).getStore_id();
//        storeHouseDao.deleteStoreHouse(store_id);
        commodityDao.deleteCommodity(commodity_id);
    }

    @Override
    public List<Commodity> getCommodityLike(String name) {
        return commodityDao.getCommodityLike(name);
    }
    public String GenerateID() {
        long microsecond = System.nanoTime() / 1000 % 1000000;
        String timeStamp = System.currentTimeMillis() / 1000L + (microsecond < 100000?"0":"") + microsecond;
//        return  "邮政编码" + timeStamp;
        return  timeStamp;
    }
}
