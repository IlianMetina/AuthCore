package com.ilian.authcore.controllers;

import com.ilian.authcore.dto.LoginResponseDto;
import com.ilian.authcore.models.User;
import com.ilian.authcore.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    public LoginResponseDto login(User user){

        LoginResponseDto userLogin = new LoginResponseDto();

    }

}
