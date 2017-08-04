package com.jpa.project.controller;

import com.jpa.project.model.Users;
import com.jpa.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * Created by IMC021 on 2017. 8. 4..
 */
@RestController
@RequestMapping("/rest/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<Users> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/load")
    public List<Users> persist(@RequestBody final Users users){
        userRepository.save(users);
        return userRepository.findAll();
    }

}
