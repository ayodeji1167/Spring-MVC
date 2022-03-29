package com.example.springmvc.controller;

import com.example.springmvc.dto.UserDto;
import com.example.springmvc.service.EmailService;
import com.example.springmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("userInfo")
public class MomsController {
    private final UserService userService;
    private final EmailService emailService;

    public MomsController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @RequestMapping("/")
    public String welcome() {
        return "welcome";

    }

    @GetMapping("/calculate")
    public String processOrder(Model model,
                               @Valid UserDto userDto,
                               BindingResult result
    ) {
        if (result.hasErrors()) {
            for (ObjectError allError : result.getAllErrors()) {
                System.out.println(allError);
            }

            return "welcome";
        }
        String res = userService.calculateLove(userDto.getUserName(), userDto.getCrushName());

        userDto.setResult(res);
        model.addAttribute("userInfo", userDto);

        return "calculate";
    }

    @GetMapping("/feedback")
    public String sendFeedBack(){

        return "feedback";
    }

    @GetMapping("/feedback-recieved")
    public String feedbackAccepted(@RequestParam String name ,
                                   @RequestParam String email,
                                   @RequestParam String feedback,
                                   Model model){
        emailService.sendEmail(name,email,feedback);

        model.addAttribute("name" , name);
        model.addAttribute("email" , email);
        model.addAttribute("feedback" , feedback);

        return "recieved";
    }
}
