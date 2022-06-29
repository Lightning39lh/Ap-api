/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.Person;
import com.ap.portfoil.PortfoilBracciale.model.Project;
import com.ap.portfoil.PortfoilBracciale.services.PersonService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService pS;
    
    @GetMapping("/get/{userId}")
    public ResponseEntity<Person> findAllByUserId(@PathVariable("userId") Long userId){
        Person person = pS.findAllByUserId(userId);
        if(person!=null){
            return ResponseEntity.status(HttpStatus.OK).body(person);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
