package mxz.service.impl;

import mxz.dao.ProviderDao;
import mxz.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mxz.service.ProviderService;

import java.sql.Timestamp;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderDao  providerDao;

    public ProviderDao getProviderDao() {
        return providerDao;
    }

    public void setProviderDao(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }

    @Override
    public Integer update(Provider provider) {
        return providerDao.update(provider);
    }

    @Override
    public Integer delete(String uid) {
        return null;
    }

    @Override
    public Provider findByPhone(String phone) {
        return null;
    }

    @Override
    public Provider findByUid(String uid) {
        return null;
    }

    @Override
    public Provider findByName(String name) {
        return providerDao.findByName(name);
    }

    @Override
    public Provider login(Provider provider) {
        //查询对应账户名的用户
        Provider findProvider = providerDao.findByName(provider.getName());
        //账户不存在或密码不正确时，返回null
        if (provider == null) {
            return null;
        }else if (provider.getPassword().equals(provider.getPassword())){
            findProvider.setUserType(1);
            return findProvider;
        }else {
            return null;
        }
    }

    @Override
    public Integer register(Provider provider) {
        if(providerDao.findByName(provider.getName()) != null) {
            //用户名已存在
            return -1;
        }
        Long microsecond = System.nanoTime() / 1000 % 1000000;
        String timeStamp = System.currentTimeMillis() / 1000L + (microsecond < 100000?"0":"") + microsecond;
        String uid = provider.getUserType() + "邮政编码" + timeStamp;
        provider.setUid(uid);

        //添加创建时间
        provider.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        return providerDao.add(provider);
    }
}
