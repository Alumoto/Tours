package com.alumoto.tours.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping({"/", "/index"})
    private String index(){
        return "index";
    }

    @RequestMapping(value = "/map")
    private String map(){
        return "map";
    }

    @RequestMapping(value = "/spot")
    private String spot(){
        return "redirect:spot/list";
    }

   

}