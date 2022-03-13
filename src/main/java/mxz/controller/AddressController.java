package mxz.controller;

import mxz.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import mxz.service.AddressService;

import java.util.ArrayList;

@Controller
public class AddressController {
    @Autowired
    private  AddressService addressService;

    public AddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    //新增地址
    public void add(Address address){
        //添加结果。1表示成功，0表示失败
        Integer result = addressService.add(address);
        if (result == 1){
            System.out.println("地址添加成功!");
            //发送新的地址数组
            addressService.findByUid(address.getUid());
        }else if (result == 0){
            System.out.println("地址添加失败!");
        }
    }
    //查询用户地址
    public void findByUid(String uid){
        //用户地址数组
        ArrayList<Address> result = addressService.findByUid(uid);
    }
    //更新地址
    public void update(Address address){
        //更新结果。1表示成功，0表示失败。
        Integer result = addressService.update(address);
        if (result == 1){
            System.out.println("地址更新成功!");
        }else if (result == 0){
            System.out.println("地址更新失败!");
        }
    }
    //删除地址
    public void delete(Long addressId ){
        //删除结果。1表示成功，0表示失败
        Integer result = addressService.delete(addressId);
        if (result == 1){
            System.out.println("地址删除成功!");
        }else if (result == 0){
            System.out.println("地址删除失败!");
        }
    }
    //设置默认地址
    public void setDefaultAddress(Address address){
        //设置默认地址结果。1表示成功，0表示失败
        Integer result = addressService.setDefaultAddress(address);
        if (result == 1){
            System.out.println("设置成功!");
        }else if (result == 0){
            System.out.println("设置失败!");
        }
    }

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","成功！！！");

        mv.setViewName("/show.jsp");
        return mv;
    }
}
