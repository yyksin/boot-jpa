package com.jpa.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by IMC021 on 2017. 8. 7..
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("message","MAIN");
        return "index";
    }

    @RequestMapping("/home")
    public String home1(Model model){
        return "home";
    }
}
