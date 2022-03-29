package com.example.springmvc.controller;

import com.example.springmvc.dto.EmailDto;
import com.example.springmvc.dto.UserDto;
import com.example.springmvc.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send-email")
    public String sendEmail(Model model) {

        return "send-email";
    }

    @GetMapping("/process-email")
    public String processEmail(@ModelAttribute("emailInfo") EmailDto emailDto ,
                               @SessionAttribute("userInfo")UserDto userDto) {

        emailService.sendEmail(userDto.getUserName(), emailDto.getUserEmail(), userDto.getResult());
        return "process-email";
    }
}
