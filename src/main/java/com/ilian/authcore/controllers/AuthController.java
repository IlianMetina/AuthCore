package com.ilian.authcore.controllers;

import com.ilian.authcore.dto.LoginRequestDto;
import com.ilian.authcore.dto.LoginResponseDto;
import com.ilian.authcore.dto.RegisterRequestDto;
import com.ilian.authcore.dto.RegisterResponseDto;
import com.ilian.authcore.services.AuthService;
import com.ilian.authcore.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService){
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("login")
    public LoginResponseDto login(@Valid BindingResult result, LoginRequestDto dto){
        if(result.hasErrors()) throw new RuntimeException("Data invalid");
        return authService.login(dto);
    }

    @PostMapping("register")
    public RegisterResponseDto register(@Valid @RequestBody RegisterRequestDto dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Data invalid");
        return authService.register(dto);
    }
}
