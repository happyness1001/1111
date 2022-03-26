package mxz.service.impl;

import mxz.dao.StoreDao;
import mxz.entity.Store;
import mxz.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreDao storeDao;

    public StoreDao getStoreDao() {
        return storeDao;
    }

    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public Integer update(Store store) {
        return storeDao.update(store);
    }

    @Override
    public Integer delete(String uid) {
        return storeDao.delete(uid);
    }

    @Override
    public Store findByPhone(String phone) {
        return null;
    }

    @Override
    public Store findByUid(String uid) {
        return storeDao.findByUid(uid);
    }

    @Override
    public Store findByName(String name) {
        return storeDao.findByName(name);
    }

    @Override
    public Store login(Store store) {
        //查询对应账户名的用户
        Store findStore = storeDao.findByName(store.getName());
        //账户不存在或密码不正确时，返回null
        if (findStore == null) {
            return null;
        } else if (store.getPassword().equals(findStore.getPassword())) {
            findStore.setUserType(2);
            return findStore;
        } else {
            return null;
        }
    }

    @Override
    public Integer register(Store store) {
        if (storeDao.findByName(store.getName()) != null) {
            //用户名已存在
            return -1;
        }
        Long microsecond = System.nanoTime() / 1000 % 1000000;
        String timeStamp = System.currentTimeMillis() / 1000L + (microsecond < 100000 ? "0" : "") + microsecond;
        String uid = store.getUserType() + "邮政编码" + timeStamp;
        store.setUid(uid);

        //添加创建时间
        store.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        return storeDao.add(store);
    }
}
