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
import com.alumoto.tours.domain.Tour;
import com.alumoto.tours.form.SpotForm;
import com.alumoto.tours.service.SpotService;
import com.alumoto.tours.service.UserService;
import com.alumoto.tours.service.TourService;

@Controller
@RequestMapping("/setup/spot/")
public class SpotSetUpController {


    @Autowired
    SpotService spotService;

    @Autowired
    UserService userService;

    @Autowired
    TourService tourService;

    @ModelAttribute
    SpotForm setUpForm() {
        return new SpotForm();
    }


    String list(Model model) {
        Page<Spot> spots = spotService.findAll(PageRequest.of(0, 20));
        model.addAttribute("spots", spots);
        return "spot/list";
    }

    @RequestMapping(value = "/add")
    String add(@ModelAttribute("SpotForm") SpotForm spotForm, @RequestParam Integer tourId, Model model) {
        // Tour tour = tourService.findById(tourId).get();
        // model.addAttribute("Tour", tour);
        return "spot/add";// これはhtmlファイルのパスを返す
    }

    @PostMapping(path = "/delete")
    String delete(@RequestParam Integer spotId, @RequestParam Integer tourId) {
        spotService.delete(spotId);
        return "redirect:/setup/edit?tourId="+tourId;
    }

    @GetMapping(value = "/detail")
    String detailForm(@RequestParam Integer spotId, @RequestParam Integer tourId, SpotForm spotForm){
        Spot spot = spotService.findById(spotId).get();
        BeanUtils.copyProperties(spot, spotForm);
        //model.addAttribute("spot", spot);
        return "spot/detail";
    }


    @PostMapping(value = "/update")
    String update(@Validated SpotForm form, @RequestParam Integer spotId, @RequestParam Integer tourId, BindingResult result) {
        if (result.hasErrors()) {
            return detailForm(spotId, tourId, form);
        }
        Spot spot = spotService.findById(spotId).get();
        spot.setSpotLng(form.getSpotLng());
        spot.setSpotLat(form.getSpotLat()); 
        spot.setSpotName(form.getSpotName());   

        spotService.update(spot);
        return "redirect:/setup/edit?tourId="+tourId;//これはURLを返す
    }


    @PostMapping(value = "/create")
    String create(@Validated SpotForm form, BindingResult result, Model model, HttpServletRequest httpServletRequest) {
        if (result.hasErrors()) {
            return list(model);
        }
        String username = httpServletRequest.getRemoteUser();
        User user = userService.findByUsername(username).get();
        Spot spot = new Spot();
        Tour tour = tourService.findById(form.getTourId()).get();
        int spotNo;
        if(tour.getSpotList() == null){
            spotNo = 1;
        }else{
            spotNo = tour.getSpotList().size() + 1;
        }

        spot.setSpotLng(form.getSpotLng());
        spot.setSpotLat(form.getSpotLat()); 
        spot.setSpotName(form.getSpotName());       
        spot.setCreator(user);
        spot.setParentTour(tour);
        spot.setSpotNo(spotNo);

        spotService.create(spot);

        return "redirect:/setup/edit?tourId="+tour.getTourId();//これはURLを返す
    }

}