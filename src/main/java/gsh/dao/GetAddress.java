package gsh.dao;

import gsh.pojo.Address;
import org.springframework.stereotype.Repository;

@Repository
public class GetAddress {
    //    获得期货最终地址
    public Address getAddress(String OrderId) {
//        调用地址接口
//        Address address = new Address();
//        模拟
        Address address = getAddress(OrderId);
        return address;
    }

}
