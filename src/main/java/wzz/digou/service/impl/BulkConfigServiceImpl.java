package wzz.digou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wzz.digou.mapper.BulkConfigMapper;
import wzz.digou.pojo.BulkConfig;
import wzz.digou.service.BulkConfigService;

import java.util.List;

@Service
public class BulkConfigServiceImpl implements BulkConfigService {
    @Autowired
    BulkConfigMapper bulkConfigMapper;

    @Override
    public List<BulkConfig> list() {
        return null;
    }

    @Override
    public void add(BulkConfig bulkConfig) {
        bulkConfigMapper.insert(bulkConfig);
        System.out.println("团购插入成功！");
    }

    @Override
    public Double getBulkPrice(Integer bulkid) {
        return bulkConfigMapper.selectBulkPrice(bulkid);
    }

    @Override
    public BulkConfig getBulkConfig(Integer bulkid) {
        return bulkConfigMapper.selectBulkConfig(bulkid);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public BulkConfig get(int id) {
        return null;
    }

    @Override
    public void update(BulkConfig category) {

    }
}
