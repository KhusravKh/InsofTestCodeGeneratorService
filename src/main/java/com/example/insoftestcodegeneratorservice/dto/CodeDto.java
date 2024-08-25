package com.example.insoftestcodegeneratorservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeDto {

    public CodeDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;

}
