package ln.service;

import org.apache.ibatis.annotations.Param;
import ln.pojo.address_distance;

import java.util.List;

public interface AddressDistanceService {
    //查询全部关系
    List<address_distance> getAddressDistanceList();
    //根据地名查询距离
    address_distance getAddressDistanceListByAddress(String from_address,  String to_address);
    //插入新的关系
    int addAddressDistance(address_distance address_distance);
    //修改信息
    int updateAddressDistance(address_distance address_distance);
    //删除信息
    int deleteAddressDistance( String from_address, String to_address);
}
