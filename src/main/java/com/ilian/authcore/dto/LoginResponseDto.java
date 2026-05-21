package com.ilian.authcore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {

//    private Long id;
    private String refreshToken;
    private String token;
//    private String firstName;
//    private String email;
}
