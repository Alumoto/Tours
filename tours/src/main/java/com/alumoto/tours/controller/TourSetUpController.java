package com.alumoto.tours.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.alumoto.tours.domain.Spot;
import com.alumoto.tours.domain.User;
import com.alumoto.tours.domain.Tour;
import com.alumoto.tours.form.TourForm;
import com.alumoto.tours.service.SpotService;
import com.alumoto.tours.service.UserService;
import com.alumoto.tours.service.TourService;

@Controller
@RequestMapping("setup")
public class TourSetUpController {


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
    @RequestMapping(value = "/add")
    String add(@ModelAttribute("TourForm") TourForm TourForm) {
        return "tour/add";// これはhtmlファイルのパスを返す
    }


    @GetMapping(value = "/main")
    String list(Model model,Principal principal) {
        User user = userService.findByUsername(principal.getName()).get();
        List<Tour> tours = tourService.findByCreator(user);
        model.addAttribute("tours", tours);
        return "tour/list";
    }

    @GetMapping(value = "/new")
    String newtour(@ModelAttribute("SpotForm") TourForm TourForm) {
        return "tour/new";// これはhtmlファイルのパスを返す
    }

    @PostMapping(value = "/create")
    String create(@Validated TourForm form, BindingResult result, Model model, Principal principal, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return list(model, principal);
        }
        User user = userService.findByUsername(principal.getName()).get();
        Tour tour = new Tour();
        BeanUtils.copyProperties(form, tour);
        tour.setCreator(user);
        tourService.create(tour);
        redirectAttributes.addAttribute("tour", tour);
        return "redirect:/setup/done";//これはURLを返す
    }
    
    @GetMapping(value = "/done")
    String done(@ModelAttribute("tour") Tour tour, Model model, BindingResult result){
            model.addAttribute("tourTitle", tour.getTourTitle());
            model.addAttribute("tourId", tour.getTourId());
            return "tour/done";
    }


    @GetMapping(value = "/edit")
    String detailForm(@RequestParam Integer tourId, TourForm tourForm, Model model){
        Tour tour = tourService.findById(tourId).get();
        BeanUtils.copyProperties(tour, tourForm);
        tour.getSpotList().sort((a,b)-> a.getSpotNo() - b.getSpotNo());
        model.addAttribute("spots", tour.getSpotList());
        return "tour/edit";
    }

    @PostMapping(value = "/update")
    String update(@Validated TourForm form, @RequestParam Integer tourId, BindingResult result, Principal principal) {
        Tour tour = new Tour();
        BeanUtils.copyProperties(form, tour);
        tour.setTourId(tourId);
        tour.setCreator(userService.findByUsername(principal.getName()).get());
        tourService.update(tour);
        return "redirect:/setup/main";//これはURLを返す
    }

}