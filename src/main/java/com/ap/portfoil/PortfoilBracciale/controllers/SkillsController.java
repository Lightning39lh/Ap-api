/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.Project;
import com.ap.portfoil.PortfoilBracciale.model.Skill;
import com.ap.portfoil.PortfoilBracciale.services.SkillsService;
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
@RequestMapping("/skills")
//@CrossOrigin(origins="*")
public class SkillsController {
    @Autowired
    SkillsService sS;
    
    @GetMapping("/get/{userId}")
    public ResponseEntity<ArrayList<Skill>> findAllByUserId(@PathVariable("userId") Long userId){
        ArrayList<Skill> skills = sS.findAllByUserId(userId);
        if(skills!=null){
            return ResponseEntity.status(HttpStatus.OK).body(skills);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity removeSkills(@PathVariable("id") Long id){
        if (sS.removeSkills(id)){ 
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
            }
    }
    @PostMapping("/create/{userId}")
    public ResponseEntity<Skill> createProject(@RequestBody Skill skill, @PathVariable("userId") Long userId) {
        sS.saveSkill(skill, userId);
        if(skill!=null){
            return ResponseEntity.status(HttpStatus.OK).body(skill);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/edit/{userId}")
    public ResponseEntity<Skill> editProject(@RequestBody Skill skill, @PathVariable("userId") Long userId) {
        sS.editSkill(skill, userId);
        if(skill!=null){
            return ResponseEntity.status(HttpStatus.OK).body(skill);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
