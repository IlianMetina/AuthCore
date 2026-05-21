package com.ilian.authcore.dto;

import com.ilian.authcore.validation.FieldsMatch;
import com.ilian.authcore.validation.StrongPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldsMatch(first = "password", second = "confirmPassword")
public class RegisterRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    @StrongPassword
    private String password;
    private String confirmPassword;
    private LocalDateTime birthdate;
    // Vérifier si LocalDateTime correspond au bon typage
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
}
