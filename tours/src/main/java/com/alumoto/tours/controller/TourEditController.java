package com.alumoto.tours.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletRequest;

import com.alumoto.tours.domain.Spot;
import com.alumoto.tours.domain.User;
import com.alumoto.tours.form.TourForm;
import com.alumoto.tours.service.SpotService;
import com.alumoto.tours.service.UserService;
import com.alumoto.tours.service.TourService;

@Controller
@RequestMapping("edit")
public class TourEditController {


    @Autowired
    SpotService spotService;

    @Autowired
    UserService userService;

    @Autowired
    TourService tourService;

    @ModelAttribute
    TourForm setUpForm() {
        return new TourForm();
    }


}