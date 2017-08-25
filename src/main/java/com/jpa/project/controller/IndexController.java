package com.jpa.project.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jpa.project.model.Users;
import com.jpa.project.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by IMC021 on 2017. 8. 7..
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String home(Model model){
        return "home";
    }

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/home")
    public String home1(Model model){
        return "home";
    }

    @RequestMapping("/search")
    @ResponseBody
    public String search(){

        List<Users> users = userRepository.findAll();

        JSONObject jsonObject = new JSONObject();

        JSONArray list = new JSONArray();

        list.put("레드마인 계정");
        list.put("bbb");
        list.put("ccc");

        jsonObject.put("values", list);


        //return "{\"0\":\"86\",\"1\":\"alex\",\"2\":\"86\",\"3\":\"alexander38\"}";
        return jsonObject.toString();
    }
}
