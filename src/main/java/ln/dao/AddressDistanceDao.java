package ln.dao;

import org.apache.ibatis.annotations.Param;
import ln.pojo.address_distance;
import java.util.List;

public interface AddressDistanceDao {
    //查询全部关系
    List<address_distance> getAddressDistanceList();
    //根据地名查询距离
    address_distance getAddressDistanceListByAddress(@Param("from_address") String from_address, @Param("to_address") String to_address);
    //插入新的关系
    int addAddressDistance(address_distance address_distance);
    //修改信息
    int updateAddressDistance(address_distance address_distance);
    //删除信息
    int deleteAddressDistance(@Param("from_address") String from_address,@Param("to_address") String to_address);
}
