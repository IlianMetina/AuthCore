package com.ilian.authcore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
