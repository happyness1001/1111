package mxz.dao;

import mxz.entity.Client;


//接口操作client表
public interface ClientDao {
    Integer add(Client client);

    Integer update(Client client);

    Client findByUid(String uid);

    Integer delete(String uid);

    Client findByPhone(String phone);

    Client findByName(String name);
}


