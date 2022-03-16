package mxz.service.impl;

import mxz.dao.ManagerDao;
import mxz.entity.Manager;
import mxz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    public ManagerDao getManagerDao() {
        return managerDao;
    }

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Override
    public Integer update(Manager manager) {
        return managerDao.update(manager);
    }

    @Override
    public Integer delete(String uid) {
        return null;
    }

    @Override
    public Manager findByPhone(String phone) {
        return null;
    }

    @Override
    public Manager findByUid(String uid) {
        return null;
    }

    @Override
    public Manager findByName(String name) {
        return managerDao.findByName(name);
    }

    @Override
    public Manager login(Manager manager) {
        //查询对应账户名的用户
        Manager findManager = managerDao.findByName(manager.getName());
        //账户不存在或密码不正确时，返回null
        if (findManager == null) {
            return null;
        }else if (manager.getPassword().equals(findManager.getPassword())){
            return findManager;
        }else {
            return null;
        }
    }

    @Override
    public Integer register(Manager manager) {
        if(managerDao.findByName(manager.getName()) != null) {
            //用户名已存在
            return -1;
        }
        Long microsecond = System.nanoTime() / 1000 % 1000000;
        String timeStamp = System.currentTimeMillis() / 1000L + (microsecond < 100000?"0":"") + microsecond;
        String uid = manager.getUserType() + "邮政编码" + timeStamp;
        manager.setUid(uid);

        //添加创建时间
        manager.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        return managerDao.add(manager);
    }

}
