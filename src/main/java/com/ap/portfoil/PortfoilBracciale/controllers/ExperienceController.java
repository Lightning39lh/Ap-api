
package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.Education;
import com.ap.portfoil.PortfoilBracciale.model.Experience;
import com.ap.portfoil.PortfoilBracciale.services.EducationService;
import com.ap.portfoil.PortfoilBracciale.services.ExperienceService;
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
@RequestMapping("/experience")
@CrossOrigin(origins="*")
public class ExperienceController {
     @Autowired
    ExperienceService eS;
    
    @GetMapping("/get/{userId}")
    public ResponseEntity<ArrayList<Experience>> findAllByUserId(@PathVariable("userId") Long userId){
        ArrayList<Experience> experience = eS.findAllByUserId(userId);
        if(experience!=null){
            return ResponseEntity.status(HttpStatus.OK).body(experience);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity removeExperience(@PathVariable("id") Long id){
        if (eS.removeExperience(id)){ 
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
            }
    }
    
    @PostMapping("/create/{userId}")
    public ResponseEntity<Experience> createProject(@RequestBody Experience experience, @PathVariable("userId") Long userId) {
        eS.saveExperience(experience, userId);
        if(experience!=null){
            return ResponseEntity.status(HttpStatus.OK).body(experience);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/edit/{userId}")
    public ResponseEntity<Experience> editProject(@RequestBody Experience experience, @PathVariable("userId") Long userId) {
        eS.editExperience(experience, userId);
        if(experience!=null){
            return ResponseEntity.status(HttpStatus.OK).body(experience);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
}
