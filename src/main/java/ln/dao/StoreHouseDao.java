package ln.dao;

import ln.pojo.Order;
import ln.pojo.StoreHouse;

import java.util.List;

public interface StoreHouseDao {

    //查询全部仓库
    List<StoreHouse> getStoreHouseList();
    //根据ID查询仓库
    StoreHouse getStoreHouseByID(int store_id);
    //插入新的仓库
    int addStoreHouse(StoreHouse storeHouse);
    //修改仓库信息
    int updateStoreHouse(StoreHouse storeHouse);
    //删除仓库信息
    int deleteStoreHouse(String store_id);
}
