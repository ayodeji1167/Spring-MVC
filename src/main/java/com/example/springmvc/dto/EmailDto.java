package com.example.springmvc.dto;

import org.springframework.ui.Model;

public class EmailDto {
    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
