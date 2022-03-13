package mxz.service;

import mxz.entity.Client;
import mxz.entity.Provider;

public interface ProviderService{
        public Integer register(Provider provider);

        public Integer update(Provider provider);

        public Integer delete(String uid);

        public Provider findByPhone(String phone);

        public Provider findByUid(String uid);

        public Provider findByName(String name);
        public Provider login(Provider provider);
}
