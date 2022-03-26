package ln.service;

import ln.pojo.Commodity;

import java.util.List;

public interface CommodityService {
    //查询全部商品
    List<Commodity> getCommodityList();

    //根据ID查询商品
    Commodity getCommodityByID(String id);

    //插入新的商品
    void addCommodity(Commodity commodity);

    //修改商品信息
    void updateCommodity(Commodity commodity);

    //删除商品信息
    void deleteCommodity(String id);

    //模糊查询
    List<Commodity> getCommodityLike(String name);
}
