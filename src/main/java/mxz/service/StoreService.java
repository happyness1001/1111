package mxz.service;

import mxz.entity.Client;
import mxz.entity.Store;

public interface StoreService {
    public Integer register(Store store);

    public Integer update(Store store);

    public Integer delete(String uid);

    public Store findByPhone(String phone);

    public Store findByUid(String uid);

    public Store findByName(String name);
    public Store login(Store store);
}
