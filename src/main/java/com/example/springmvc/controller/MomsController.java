package com.example.springmvc.controller;

import com.example.springmvc.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class MomsController {

    @RequestMapping("/")
    public String welcome(@ModelAttribute("userInfo") UserDto userDto) {
        return "welcome";

    }


    @GetMapping("/calculate")
    public String processOrder(Model model,
                               @Valid UserDto userDto,
                               BindingResult result,
                               HttpServletRequest request) {
        if (result.hasErrors()) {
            for (ObjectError allError : result.getAllErrors()) {
                System.out.println(allError);
            }

            return "welcome";
        }

        model.addAttribute("userInfo", userDto);

       HttpSession session = request.getSession();
       session.setAttribute("username1" , userDto.getUserName());

        return "calculate";
    }


}
