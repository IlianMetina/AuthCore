package com.ilian.authcore.controllers;

import com.ilian.authcore.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("admin")
@RestController
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("test")
    public String testAdmin(){
        return "Test réussi";
    }



}
