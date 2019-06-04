package com.alumoto.tours;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value="/index")
    private String index(){
        return "index";
    }

    @RequestMapping(value = "/map")
    private String map(){
        return "map";
    }

    @RequestMapping(value = "/addspot")
    private String addspot(){
        return "addspot";
    }

}