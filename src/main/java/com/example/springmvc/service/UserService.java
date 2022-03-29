package com.example.springmvc.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String calculateLove(String username, String crusname) {

        int wordLength = username.length() + crusname.length();
        int index = wordLength % 5;

        return switch (index) {
            case 0:
                yield "FRIEND";
            case 1:
                yield "LOVE";
            case 2:
                yield "AFFECTION";
            case 3:
                yield "MARRIAGE";
            case 4:
                yield "ENEMY";
            default:
                yield "UNRESOLVED";

        };

    }
}
