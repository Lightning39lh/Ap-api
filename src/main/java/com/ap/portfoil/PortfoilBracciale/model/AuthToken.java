package com.ap.portfoil.PortfoilBracciale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthToken {
    private String token;
    private String username;


    public AuthToken(String token){
        this.token = token;
    }
}