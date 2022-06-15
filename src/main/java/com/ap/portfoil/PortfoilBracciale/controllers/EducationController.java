/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.Education;
import com.ap.portfoil.PortfoilBracciale.model.Project;
import com.ap.portfoil.PortfoilBracciale.services.EducationService;
import com.ap.portfoil.PortfoilBracciale.services.ProjectService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education")
public class EducationController {
     @Autowired
    EducationService eS;
    
    @GetMapping("/{userId}")
    public ResponseEntity<ArrayList<Education>> findAllByUserId(@PathVariable("userId") Long userId){
        ArrayList<Education> educations = eS.findAllByUserId(userId);
        if(educations!=null){
            return ResponseEntity.status(HttpStatus.OK).body(educations);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
