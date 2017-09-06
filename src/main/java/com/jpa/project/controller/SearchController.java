package com.jpa.project.controller;

import com.google.gson.Gson;
import com.jpa.project.model.T_SEARCH;
import com.jpa.project.repository.SearchRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IMC021 on 2017. 8. 7..
 */
@Controller
public class SearchController {
    @RequestMapping("/")
    public String home(Model model){
        return "searchBar";
    }

    @Autowired
    SearchRepository searchRepository;

    @RequestMapping("/home")
    public String home1(Model model){
        return "searchBar";
    }

    @RequestMapping("/search")
    @ResponseBody
    public String search(){

        List<T_SEARCH> memoList = searchRepository.findMemo();

        JSONObject jsonObject = new JSONObject();

        JSONArray list = new JSONArray();

        list.put("레드마인 계정");
        list.put("bbb");
        list.put("ccc");

        jsonObject.put("values", list);

        String result = new Gson().toJson(memoList);

        return result;
    }
}
