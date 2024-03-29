/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.Person;
import com.ap.portfoil.PortfoilBracciale.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
//@CrossOrigin(origins="*")
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
    
    @PostMapping("/create/{id}")
    public ResponseEntity<Person> createPersona(@RequestBody Person person,@PathVariable Long UserId) {
        pS.savePerson(person,UserId);
        if(person!=null){
            return ResponseEntity.status(HttpStatus.OK).body(person);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }
    
    @PostMapping("/edit/{id}") 
    public ResponseEntity<Person> editPerson (@PathVariable("id") Long UserId, @RequestBody Person person)
     { 
        pS.editPerson(person,UserId);
        if(person!=null){
            return ResponseEntity.status(HttpStatus.OK).body(person);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    /*
    @DeleteMapping("/{id}")
    public ResponseEntity removePerson(@PathVariable("id") Long id){
        if (pS.removePerson(id)){ 
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
            }
    }*/
    
}
