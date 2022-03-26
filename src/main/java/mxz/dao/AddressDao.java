package mxz.dao;

import mxz.entity.Address;

import java.util.ArrayList;

public interface AddressDao {
    Integer add(Address address);

    Integer update(Address address);

    ArrayList<Address> findByUid(String uid);

    Integer delete(Long addressId);

    Address findDefaultAddress(String uid);
}
