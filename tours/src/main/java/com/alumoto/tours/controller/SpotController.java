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

import com.alumoto.tours.domain.Spot;
import com.alumoto.tours.form.SpotForm;
import com.alumoto.tours.service.SpotService;


import java.util.Optional;

@Controller
@RequestMapping("spot")
public class SpotController {


    @Autowired
    SpotService spotService;

    @ModelAttribute
    SpotForm setUpForm() {
        return new SpotForm();
    }

    @GetMapping(value = "/list")
    String list(Model model) {
        Page<Spot> spots = spotService.findAll(PageRequest.of(0, 20));
        model.addAttribute("spots", spots);
        return "spot/list";
    }

    @RequestMapping(value = "/add")
    String add(@ModelAttribute("SpotForm") SpotForm spotForm) {
        return "spot/add";// これはhtmlファイルのパスを返す
    }

    @PostMapping(path = "/delete")
    String delete(@RequestParam Integer spotId) {
        spotService.delete(spotId);
        return "redirect:/spot/list";
    }

    @GetMapping(value = "/detail")
    String detail(@RequestParam Integer id, Model model){
        Spot spot = spotService.findById(id).get();
        model.addAttribute("Spot", spot);
        return "spot/detail";
    }


    @PostMapping
    String create(@Validated SpotForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return list(model);
        }
        Spot spot = new Spot();
        BeanUtils.copyProperties(form, spot);
        spotService.create(spot);
        return "redirect:spot/list";//これはURLを返す
    }

}