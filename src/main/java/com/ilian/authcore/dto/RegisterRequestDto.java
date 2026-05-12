package com.ilian.authcore.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegisterRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime birthdate;
    // Vérifier si LocalDateTime correspond au bon typage
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
}
