package mxz.service;

import mxz.entity.Address;

import java.util.ArrayList;

public interface AddressService {
    Integer add(Address address);

    Integer update(Address address);

    Integer delete(Long addressId);

    ArrayList<Address> findByUid(String uid);

    Integer setDefaultAddress(Address address);

}
