package sh.project.bookloginit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("hi")
    public String hi(){
        return "hi_view";
    }
}
