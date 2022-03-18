package ln.dlut.ln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/ln")
public class LnIndexController {
    @RequestMapping("/index")
    public String index(){
       return "storage/index";
   }
}
