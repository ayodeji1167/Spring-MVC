package com.example.springmvc.controller;

import com.example.springmvc.dto.EmailDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EmailController {

    @GetMapping("/send-email")
    public String sendEmail(Model model) {

        return "send-email";
    }

    @GetMapping("/process-email")
    public String processEmail(@ModelAttribute("emailInfo") EmailDto emailDto) {
        return "process-email";
    }
}
