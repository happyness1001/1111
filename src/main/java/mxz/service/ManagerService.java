package mxz.service;

import mxz.entity.Manager;

public interface ManagerService {
    public Integer register(Manager manager);

    public Integer update(Manager manager);

    public Integer delete(String uid);

    public Manager findByPhone(String phone);

    public Manager findByUid(String uid);

    public Manager findByName(String name);
    public Manager login(Manager manager);
}
