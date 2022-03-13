package mxz.service;

import mxz.entity.Client;

import java.util.ArrayList;


public interface ClientService {
    public Integer register(Client client);

    public Client login(Client client);

    public Integer update(Client client);

    public Integer delete(String uid);

    public Client findByPhone(String phone);

    public Client findByUid(String uid);

    public Client findByName(String name);
}
