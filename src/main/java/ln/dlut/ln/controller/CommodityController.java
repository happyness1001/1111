package ln.dlut.ln.controller;

import ln.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ln.pojo.Commodity;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    @Qualifier("commodityIml")
    private CommodityService commodityService;

    //查询库存并返回到页面

    @RequestMapping("/allCommodity")
    public String list(Model model){
        List<Commodity> commodityList = commodityService.getCommodityList();
        model.addAttribute("commodityList",commodityList);
        return "allCommodity";
    }
    //跳转到查询商品界面
    @RequestMapping("/toQuery")
    public String toQuery(){
        return "queryCommodity";
    }
    //根据商品名称模糊查询商品
    @RequestMapping("/getCommodityLike")
    public String getCommodityLike(String name,Model model){
        System.out.println(name);
        List<Commodity> commodityList = commodityService.getCommodityLike(name);
        System.out.println(commodityList);
        model.addAttribute("commodityList",commodityList);
        return "commodityFromName";
    }
    //根据商品id查询商品详情
    @RequestMapping("/getCommodityById")
    public String query(String id,Model model){
//        System.out.println(id);
        Commodity commodity = commodityService.getCommodityByID(id);
        model.addAttribute("commodity",commodity);
        return "commodityFromId";
    }
    //跳转到添加商品界面
    @RequestMapping("/toCommodity")
    public String toAdd(){
        return "addCommodity";
    }
    //添加商品
    @RequestMapping("addCommodity")
    public String add(Commodity commodity){

        commodityService.addCommodity(commodity);
        return "redirect:/commodity/allCommodity";
    }
    //跳转到修改界面
    @RequestMapping("/toUpdate")
    public String toUpdate(String commodity_id ,Model model){
        Commodity commodity = commodityService.getCommodityByID(commodity_id);
        model.addAttribute("QCommodity",commodity);
        return "updateCommodity";
    }
    //修改商品信息
    @RequestMapping("/update")
    public String update(Commodity commodity){
        System.out.println(commodity);
        commodityService.updateCommodity(commodity);
        return "redirect:/commodity/allCommodity";
    }
    //删除商品
    @RequestMapping("/delete")
    public String drop(String commodity_id){
        System.out.println(commodity_id);
        commodityService.deleteCommodity(commodity_id);
        return "redirect:/commodity/allCommodity";
    }


}
