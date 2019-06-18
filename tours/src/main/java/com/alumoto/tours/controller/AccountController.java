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
public class AccountController {

    @Autowired
    UserService userServise;

    @ModelAttribute
    public UserForm setupForm(){
        return new UserForm();
    }


    @RequestMapping(value="account")
    String userForm(){
        return "account/userForm";

    }
    @PostMapping(value = "account")
    String create(@Validated UserForm form, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
        return "account/userForm";
    }
    User user = new User();
    user.setUsername(form.getUsername());
    userServise.create(user, form.getPassword());
    return "redirect:/acount/complete";
}
 
    

}   