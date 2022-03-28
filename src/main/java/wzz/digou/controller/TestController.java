package wzz.digou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.Queue;

@Controller
@RequestMapping("")
public class TestController {
    public static Queue<Integer> list = new LinkedList<>();

    public void addList(int num) {
        synchronized (list) {
            list.add(num);
            list.notifyAll();
        }
    }

    //商城主页
    @RequestMapping("testlist")
    public void home(Model model) {
        synchronized (list) {
            list.add(1);
            list.notifyAll();
        }
//        addList(1);
        System.out.println("add + 1");
//        addList(2);
//        System.out.println("add + 2");
//        addList(3);
//        System.out.println("add + 3");
//        addList(4);
//        System.out.println("add + 4");
    }
}
