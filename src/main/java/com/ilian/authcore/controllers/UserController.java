package com.ilian.authcore.controllers;

import com.ilian.authcore.services.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

}
