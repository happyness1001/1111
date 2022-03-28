package wzz.digou.service;

import wzz.digou.pojo.BulkConfig;

import java.util.List;

public interface BulkConfigService {
    void add(BulkConfig bulkConfig);

    Double getBulkPrice(Integer bulkid);

    BulkConfig getBulkConfig(Integer bulkid);

    List<BulkConfig> list();

    void delete(int id);

    BulkConfig get(int id);

    void update(BulkConfig category);
}
