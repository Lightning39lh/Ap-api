/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.Education;
import com.ap.portfoil.PortfoilBracciale.services.EducationService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education")
@CrossOrigin("*")
public class EducationController {
     @Autowired
    EducationService eS;
    
    @GetMapping("/get/{userId}")
    public ResponseEntity<ArrayList<Education>> findAllByUserId(@PathVariable("userId") Long userId){
        ArrayList<Education> educations = eS.findAllByUserId(userId);
        if(educations!=null){
            return ResponseEntity.status(HttpStatus.OK).body(educations);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity removeEducation(@PathVariable("id") Long id){
        if (eS.removeEducation(id)){ 
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
            }
    }
    
    
    @PostMapping("/create/{userId}")
    public ResponseEntity<Education> createProject(@RequestBody Education education, @PathVariable("userId") Long userId) {
        eS.saveEducation(education, userId);
        if(education!=null){
            return ResponseEntity.status(HttpStatus.OK).body(education);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/edit/{userId}")
    public ResponseEntity<Education> editProject(@RequestBody Education education, @PathVariable("userId") Long userId) {
        eS.editEducation(education, userId);
        if(education!=null){
            return ResponseEntity.status(HttpStatus.OK).body(education);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
