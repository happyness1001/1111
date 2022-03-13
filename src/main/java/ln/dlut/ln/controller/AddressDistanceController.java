package ln.dlut.ln.controller;

import ln.service.AddressDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ln.pojo.address_distance;

@Controller
//对应于address——distance数据库的增删改查和其相应的页面
public class AddressDistanceController {
    @Autowired
    private AddressDistanceService addressDistanceService;
    //需要一个页面，增加数据库=====================================同理增删改查都需要  暂时先不写
    public void addAddressDistance(address_distance addressDistance){
        addressDistanceService.addAddressDistance(addressDistance);
    }
}
