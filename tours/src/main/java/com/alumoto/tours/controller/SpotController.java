package com.alumoto.tours.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.alumoto.tours.domain.Spot;
import com.alumoto.tours.form.SpotForm;
import com.alumoto.tours.service.SpotService;

@Controller
@RequestMapping("spot/add")
public class SpotController {


    @Autowired
    SpotService spotService;

    @ModelAttribute
    SpotForm setUpForm() {
        return new SpotForm();
    }
    
    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        Page<Spot> spots = spotService.findAll(PageRequest.of(0,20));
        model.addAttribute("spots", spots);
        // Spring bootでは画面のパスは「templates/customers/list.html」となる
        return "spot/list";
    }
    


    @PostMapping
    String create(@Validated SpotForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return list(model);
        }
       Spot spot = new Spot();
        BeanUtils.copyProperties(form, spot);
        spotService.create(spot);
        return "redirect:spot/list";
    }

}