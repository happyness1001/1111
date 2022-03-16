package mxz.dao;

import mxz.entity.Provider;

public interface ProviderDao {
    Integer add(Provider provider);

    Integer update(Provider provider);

    Provider findByUid(String uid);

    Integer delete(String uid);

    Provider findByName(String name);
}
