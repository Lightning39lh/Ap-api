package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.config.JwtTokenUtil;
import com.ap.portfoil.PortfoilBracciale.model.AuthToken;
import com.ap.portfoil.PortfoilBracciale.model.MyUser;
import com.ap.portfoil.PortfoilBracciale.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
//@CrossOrigin(origins="*")

public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService us;

    @PostMapping
    public ResponseEntity<AuthToken> register(@RequestBody MyUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
       
        
        
        final UserDetails user = us.loadUserByUsername(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.status(HttpStatus.OK).body(new AuthToken(token, user.getUsername()));
    }
}

    /*
    @GetMapping("/{user}/{password}")
    public ResponseEntity createToken(@PathVariable("user") String user, @PathVariable("password") String password) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(user, password));
        UserDetails uD = uS.loadUserByUsername(user);
        String token = jTU.generateToken(uD);
        return ResponseEntity.status(200).body(token);
    }*/


