package com.jpa.project.controller;

import com.jpa.project.entity.T_USER;
import com.jpa.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by IMC021 on 2017. 8. 4..
 */
@Controller
public class UserController {


//    @GetMapping("/all11")
//    public List<User> getAll(){
//        return userRepository.findAll();
//    }
//
//    @PostMapping("/load")
//    public List<User> persist(@RequestBody final User user){
//
//        return null;
//    }
    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/create")
    public String userCreate(T_USER t_user){

        T_USER user = userRepository.findOneByUid(t_user.getUid());

        if(user != null){

        }

        //비밀번호 암호화
        String password = new BCryptPasswordEncoder().encode(t_user.getUpassword());
        t_user.setUpassword(password);

        userRepository.save(t_user);
        return "redirect:/";
    }

    @GetMapping("/my")
    public String my(Model model, Principal principal){
        String uid = principal.getName();
        T_USER user = userRepository.findOneByUid(uid);
        model.addAttribute("user", user);
        return "my";
    }

    @PostMapping("/user/update")
    public String userUpdate(T_USER t_user){
        //비밀번호 암호화
        String password = new BCryptPasswordEncoder().encode(t_user.getUpassword());
        t_user.setUpassword(password);

        userRepository.save(t_user);
        return "redirect:/";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/secured/all")
    public String securedhello(){
        return "secured hello";
    }
}
