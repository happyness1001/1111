package ljy.digou.controller;

import ljy.digou.pojo.Category;
import ljy.digou.pojo.Result;
import ljy.digou.service.CategoryService;
import ljy.digou.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

/*
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> cs= categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
*/


//    @RequestMapping("admin_category_delete")
//    public String delete(int id,HttpSession session) throws IOException {
//        categoryService.delete(id);
//
//        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
//        File file = new File(imageFolder,id+".jpg");
//        file.delete();
//
//        return "redirect:/admin_category_list";
//    }

    //商品添加
    @RequestMapping("getCategory")
    public String getCategory(Model model) {
        List<Category> cs = categoryService.list();
        model.addAttribute("cs", cs);
        return "jsp/admin/admin_addProduct";
    }

    //分类管理页面
    @RequestMapping("toCategory")
    public String toCategory(Model model) {
        List<Category> cs = categoryService.list();
        model.addAttribute("cs", cs);
        return "jsp/admin/admin_managerCategory";
    }

    @ResponseBody
    @RequestMapping("admin_category_add")
    public Result<Category> add(Category c) {
        List<Category> cs = categoryService.list();
        for (Category cg : cs)
            if (cg.getName().equals(c.getName()))
                return new ResultUtil<Category>().setErrorMsg("分类已存在！");
        categoryService.add(c);
        return new ResultUtil<Category>().setData(c);
    }


    @RequestMapping("/toEditCategory")
    public String toEditCategory(Model model, int id) {
        Category c = categoryService.get(id);
        model.addAttribute("cg", c);
        return "jsp/admin/editCategory";
    }

    @ResponseBody
    @RequestMapping("admin_category_edit")
    public Result<Category> edit(Category c, Model model) {
        List<Category> cs = categoryService.list();
        for (Category cg : cs)
            if (cg.getName().equals(c.getName()))
                return new ResultUtil<Category>().setErrorMsg("分类已存在！");
        categoryService.update(c);
        model.addAttribute("c", c);
        return new ResultUtil<Category>().setData(c);
    }
}