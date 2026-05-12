package com.ilian.authcore.controllers;

import com.ilian.authcore.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
}
