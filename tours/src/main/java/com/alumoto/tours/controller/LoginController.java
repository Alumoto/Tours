package com.alumoto.tours.controller;

import com.alumoto.tours.form.UserForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController<UserServise> {

    @Autowired
    UserServise userServise;

    @GetMapping(path = "loginForm")
    String loginForm(){
        return "loginForm";
    }

    @ModelAttribute
    public UserForm setupForm(){
        return new UserForm();
    }

    @RequestMapping(value="user")
    String userForm(){
        return "account/userForm";

    }
}