package com.alumoto.tours.controller;


import com.alumoto.tours.form.UserForm;
import com.alumoto.tours.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @Autowired
    UserService userServise;

    @ModelAttribute
    public UserForm setupForm(){
        return new UserForm();
    }


    @GetMapping(path = "loginForm")
    String loginForm(@ModelAttribute("userForm") UserForm userForm){
        return "loginForm";
    }
    
}   