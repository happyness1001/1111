package ln.service;

import ln.dao.AddressDistanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ln.pojo.address_distance;

import java.util.List;

@Service
public class AddressDistanceIml implements AddressDistanceService{

    @Autowired
    @Qualifier("addressDistanceDao")
    private AddressDistanceDao addressDistanceDao;

    @Override
    public List<address_distance> getAddressDistanceList() {
        return addressDistanceDao.getAddressDistanceList();
    }

    @Override
    public address_distance getAddressDistanceListByAddress(String from_address, String to_address) {
        return addressDistanceDao.getAddressDistanceListByAddress(from_address,to_address);
    }

    @Override
    public int addAddressDistance(address_distance address_distance) {
        ln.pojo.address_distance addressDistance = new address_distance(address_distance.getTo_address(),address_distance.getFrom_address(),address_distance.getDistance());
        addressDistanceDao.addAddressDistance(address_distance);
        addressDistanceDao.addAddressDistance(addressDistance);
        return 0;
    }

    @Override
    public int updateAddressDistance(address_distance address_distance) {
        ln.pojo.address_distance addressDistance = new address_distance(address_distance.getTo_address(),address_distance.getFrom_address(),address_distance.getDistance());
        addressDistanceDao.updateAddressDistance(address_distance);
        addressDistanceDao.updateAddressDistance(addressDistance);
        return 0;
    }

    @Override
    public int deleteAddressDistance(String from_address, String to_address) {
        addressDistanceDao.deleteAddressDistance(from_address,to_address);
        addressDistanceDao.deleteAddressDistance(to_address,from_address);
        return 0;
    }

    public void setAddressDistanceDao(AddressDistanceDao addressDistanceDao) {
    }
}