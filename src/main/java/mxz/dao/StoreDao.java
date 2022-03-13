package mxz.dao;

import mxz.entity.Store;

public interface StoreDao {
    Integer add(Store store);

    Integer update(Store store);

    Store findByUid(String uid);

    Integer delete(String uid);

    Store findByName(String name);

}
