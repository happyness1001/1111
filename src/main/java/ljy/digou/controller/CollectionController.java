package ljy.digou.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ljy.digou.pojo.Collection;
import ljy.digou.pojo.Product;
import ljy.digou.pojo.User;
import ljy.digou.service.CollectionService;
import ljy.digou.service.ProductService;
import ljy.digou.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class CollectionController {

    @Autowired
    CollectionService collectionService;
    @Autowired
    ProductService productService;

    //显示用户收藏
    @RequestMapping("shouCangPage")
    public String UsershouCang(HttpSession session) {

        User user = (User) session.getAttribute("user");
        List<Collection> collectionList = collectionService.getUserSC(user.getName());
//        System.out.println(collectionList.size());
        List<Product> productList = new ArrayList<>();
        for (Collection c : collectionList) {
            productList.add(productService.get(c.getPid()));
        }

        //放到  服务器上 供我取出来
        session.removeAttribute("collectionList");
        session.removeAttribute("shoucangPd");
        session.setAttribute("collectionList", collectionList);
        session.setAttribute("shoucangPd", productList);

        return "jsp/include/fore/shouCangPage";
    }


    //添加产品收藏
    @RequestMapping("shoucangSucceed")
    public String shoucangPd(int pid, HttpSession session) {
        if (productService.get(pid) == null) {
            System.out.println("已经成功收藏过了！");
            return "jsp/include/fore/shoucangSucceed";
        }
        User user = (User) session.getAttribute("user");
        Collection collection = new Collection();
        collection.setPid(pid);
        if (user == null) {
            return "jsp/fore/login";
        }
        collection.setScuname(user.getName());
        collectionService.add(collection);
        return "jsp/include/fore/shoucangSucceed";
    }


    //收藏产品删除
    @RequestMapping("shoucangDelete")
    public String shoucangDelete(HttpSession session, int id) {

        //control  调用 sevice层

        //sevice层具体删除去
        collectionService.delete(id);

        return "redirect:shouCangPage";
    }


    //后台的 收藏列表
    @RequestMapping("showAllCollection")
    public String showAllCollection(HttpSession session, Model model, Page page) {

        //分页助手
        PageHelper.offsetPage(page.getStart(), page.getCount());

        //收藏的集合
        List<Collection> collecList = collectionService.list();


        List<Product> collecList_plist = new ArrayList<>();


        for (Collection c : collecList) {
            collecList_plist.add(productService.get(c.getPid()));
        }

        int total = (int) new PageInfo<>(collecList).getTotal();
        page.setTotal(total);

        model.addAttribute("page", page);
        model.addAttribute("collecList", collecList);
        model.addAttribute("collecList_plist", collecList_plist);

//
//        session.setAttribute("collecList",collecList);
//        session.setAttribute("collecList_plist",collecList_plist);

        return "jsp/admin/admin_listCollection";
    }


}
