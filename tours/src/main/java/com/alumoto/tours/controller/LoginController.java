package com.alumoto.tours.controller;

import java.util.Date;

import com.alumoto.tours.domain.User;
import com.alumoto.tours.form.UserForm;
import com.alumoto.tours.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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