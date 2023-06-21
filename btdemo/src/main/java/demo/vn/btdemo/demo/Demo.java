package demo.vn.btdemo.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("author")
public class Demo {

    @GetMapping("ay")
    public String index(Model model){


        model.addAttribute("a","oy");

        return "index1.html";

    }

    @GetMapping("oy")
    public String oy(RedirectAttributes model) {


        return "redirect:https://vuetifyjs.com/en/";
    }

}
