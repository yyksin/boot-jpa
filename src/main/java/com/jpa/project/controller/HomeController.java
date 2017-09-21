package com.jpa.project.controller;

import com.google.gson.Gson;
import com.jpa.project.cache.SearchCache;
import com.jpa.project.model.T_SEARCH;
import com.jpa.project.repository.SearchRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    SearchCache searchCache;

    /**
     * 로그인
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

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
    public String list(Model model,@RequestParam(value = "searchTxt",required = false) String str
                        ,@RequestParam(value = "limit",defaultValue = "10") int limit
                       ,@RequestParam(value="page",defaultValue = "1") int page){



        Page<T_SEARCH>  PageList = null;
        //페이지수, sort
        PageRequest pageRequest = new PageRequest(page-1,limit,new Sort(Sort.Direction.ASC,"id"));

        if(StringUtils.isNotEmpty(str)){
            //list = searchRepository.findByMemo(str);
            PageList = searchRepository.findLikeMemo(str,pageRequest);
        }else{
            PageList = searchRepository.findAll(pageRequest);
            logger.info("size {}",PageList.getContent());
        }

        long totalPage = PageList.getTotalPages();
        long totalCnt = PageList.getTotalElements();

        logger.info("totalpage : {}, totalCnt : {}, currentPage : {}",totalPage,totalCnt,page);

        List<T_SEARCH> result = PageList.getContent();

        model.addAttribute("list", result);
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

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
        searchCache.refreshAll();
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

        logger.info("json data : {}", result);
        return result;
    }

}
