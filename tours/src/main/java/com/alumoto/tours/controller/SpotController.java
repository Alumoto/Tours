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
import com.alumoto.tours.form.SpotForm;
import com.alumoto.tours.service.SpotService;
import com.alumoto.tours.service.UserService;

@Controller
@RequestMapping("spot")
public class SpotController {


    @Autowired
    SpotService spotService;

    @Autowired
    UserService userService;

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
    String detailForm(@RequestParam Integer id, SpotForm spotForm){
        Spot spot = spotService.findById(id).get();
        BeanUtils.copyProperties(spot, spotForm);
        //model.addAttribute("spot", spot);
        return "spot/detail";
    }


    @PostMapping(value = "/update")
    String update(@Validated SpotForm form, @RequestParam Integer id, BindingResult result) {
        if (result.hasErrors()) {
            return detailForm(id, form);
        }
        Spot spot = new Spot();
        BeanUtils.copyProperties(form, spot);
        spot.setSpotId(id);
        spotService.update(spot);
        return "redirect:/spot/list";//これはURLを返す
    }


    @PostMapping
    String create(@Validated SpotForm form, BindingResult result, Model model, HttpServletRequest httpServletRequest) {
        if (result.hasErrors()) {
            return list(model);
        }
        String username = httpServletRequest.getRemoteUser();
        User user = userService.findByUsername(username).get();
        Spot spot = new Spot();
        BeanUtils.copyProperties(form, spot);
        spot.setCreatedUser(user);
        spotService.create(spot);
        return "redirect:spot/list";//これはURLを返す
    }

}