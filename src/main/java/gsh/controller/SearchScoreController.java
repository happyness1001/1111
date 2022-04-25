package gsh.controller;

import gsh.service.SearchScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wzz.digou.pojo.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/gsh")
public class SearchScoreController {

    @Autowired
    @Qualifier("searchScoreIml")
    private SearchScoreService searchScoreService;

    @RequestMapping("/wb")
    public void search(){
        System.out.println(111);
        System.out.println(searchScoreService.search_score(5,959));
        return;
    }
    @RequestMapping("/gsh")
    public void session(HttpSession session){
        System.out.println(222);
        System.out.println(session);
        User user = (User) session.getAttribute("user");
        System.out.println(user.getId());
        return;
    }

}
