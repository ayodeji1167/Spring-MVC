package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MomsController {

    @GetMapping("/welcome")
    public String welcome(Model model){
        return "welcome";
    }

    @GetMapping("/process")
    public String processOrder(Model model , @RequestParam(name = "FoodType") String foodType){
        model.addAttribute("food" , foodType);
        return "process";
    }
}
