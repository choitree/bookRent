package com.company.bookRent.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserSignupDTO {

    private String loginId;
    private String password;
    private String name;
    private String email;
}
