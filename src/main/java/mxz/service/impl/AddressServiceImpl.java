package mxz.service.impl;

import mxz.dao.AddressDao;
import mxz.entity.Address;
import mxz.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Integer add(Address address) {
        //设置添加时间
        Timestamp timestamp = new Timestamp(new Date().getTime());
        address.setCreateTime(timestamp);
        address.setUpdateTime(timestamp);
        return addressDao.add(address);
    }

    @Override
    public Integer update(Address address) {
        //设置修改时间
        address.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return addressDao.update(address);
    }

    @Override
    public Integer delete(Long addressId) {
        return addressDao.delete(addressId);
    }

    @Override
    public ArrayList<Address> findByUid(String uid) {
        return addressDao.findByUid(uid);
    }

    @Override
    public Integer setDefaultAddress(Address address){
        //查询当前默认地址
        Address current = addressDao.findDefaultAddress(address.getUid());
        if (current != null){
            //取消当前默认地址
            current.setIsDefault(0);
            addressDao.update(current);
        }
        //将目标地址设置为默认标识
        address.setIsDefault(1);
        return addressDao.update(address);
    }
}
