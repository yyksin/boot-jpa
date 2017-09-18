package com.jpa.project.controller;

import com.google.gson.Gson;
import com.jpa.project.cache.SearchCache;
import com.jpa.project.model.T_SEARCH;
import com.jpa.project.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by IMC021 on 2017. 9. 18..
 */
@Controller
public class HomeController {

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    SearchCache searchCache;

    /**
     * 검색바
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String home(Model model){
        return "bar";
    }

    /**
     * 목록
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "searchTxt",required = false) String str){

        List<T_SEARCH> list = null;

        if(str != null){
            list = searchRepository.findByMemo(str);
        }else{
            list = searchRepository.findAll();
        }

        model.addAttribute("list", list);
        return "list";
    }

    /**
     * 등록 페이지
     * @return
     */
    @GetMapping("/new")
    public String newTask(){
        return "update";
    }

    /**
     * 수정 페이지
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id){
        T_SEARCH obj = searchRepository.findOne(id);
        model.addAttribute("obj", obj);
        return "update";
    }

    /**
     * 삭제
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        searchRepository.delete(id);
        return "redirect:/list";
    }

    /**
     * 등록 및 수정
     * @param t_search
     * @return
     */
    @PostMapping("/save")
    public String save(@ModelAttribute T_SEARCH t_search){
        searchRepository.save(t_search);
        return "redirect:/list";
    }

    /**
     * 검색 호출
     * @return
     */
    @RequestMapping("/barAjax")
    @ResponseBody
    public String barAjax(){

        searchCache.getAllMemo();

        //List<T_SEARCH> memoList = searchRepository.findAll();
        //ehcache를 사용하여 셀렉트를 최초 한번만 한다.
        List<T_SEARCH> memoList = searchCache.getAllMemo();

        String result = new Gson().toJson(memoList);

        return result;
    }

}