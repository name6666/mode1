package net.jhc.app_info_mng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

    @GetMapping("/")
    public String toIndex(){
        return "index";
    }
}
