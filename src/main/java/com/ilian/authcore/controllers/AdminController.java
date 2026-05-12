package com.ilian.authcore.controllers;

import com.ilian.authcore.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService){
        this.userService = userService;
    }

}
