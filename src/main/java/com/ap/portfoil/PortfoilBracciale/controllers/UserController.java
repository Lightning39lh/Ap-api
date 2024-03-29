package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.MyUser;
import com.ap.portfoil.PortfoilBracciale.services.MyUserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MyUsers")
//@CrossOrigin(origins="*")
public class UserController {
    
    @Autowired
    private MyUserService uS;
    
    @GetMapping("/get")
    public ResponseEntity<ArrayList<MyUser>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(uS.getAllUsers());
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<Long> findIdByUserName(@PathVariable("username") String username){
        Long id = uS.findByUsername(username);
        if(id!=null){
            return ResponseEntity.status(HttpStatus.OK).body(id);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<MyUser> save(@RequestBody MyUser user){
        uS.saveUser(user);
        return ResponseEntity.ok().body(user);
    }
    
    @PutMapping
    public ResponseEntity<String> put(@RequestBody MyUser user){
        if(uS.editByUserName(user)){
            return ResponseEntity.status(HttpStatus.OK).body("Edited Succesfull");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
        }
    }
    
    
}
