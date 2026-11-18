package com.ilian.authcore.controllers;

import com.ilian.authcore.models.User;
import com.ilian.authcore.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("findByEmail/{email}")
    public User findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }
}
