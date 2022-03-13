package mxz.dao;

import mxz.entity.Client;

import java.util.ArrayList;


//接口操作client表
public interface ClientDao {
    Integer add(Client client);

    Integer update(Client client);

    Client findByUid(String uid);

    Integer delete(String uid);

//    Client findByPhone(String phone);

    Client findByName(String name);
}


