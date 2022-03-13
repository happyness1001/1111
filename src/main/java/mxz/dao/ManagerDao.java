package mxz.dao;

import mxz.entity.Manager;

//接口操作manager表
public interface ManagerDao {
    Integer add(Manager manager);

    Integer update(Manager manager);

    Manager findByUid(String uid);

    Integer delete(String uid);


    public  Manager findByName(String name);
}
