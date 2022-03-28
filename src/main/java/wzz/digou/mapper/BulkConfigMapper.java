package wzz.digou.mapper;


import wzz.digou.pojo.BulkConfig;

public interface BulkConfigMapper {
//    //删除通过主键
//    int deleteByPrimaryKey(Integer id);

    //插入
    int insert(BulkConfig bulkConfig);

    //根据团购配置主键查找团购价格
    Double selectBulkPrice(Integer bulkid);

    BulkConfig selectBulkConfig(Integer bulkid);

//    //通过主键查找
//    BulkConfig selectByPrimaryKey(Integer id);
//
//    //通过主键更新
//    int updateByPrimaryKey(BulkConfig bulkConfig);
}
