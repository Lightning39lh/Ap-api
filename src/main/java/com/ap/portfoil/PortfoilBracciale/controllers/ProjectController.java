
package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.Project;
import com.ap.portfoil.PortfoilBracciale.services.ProjectService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService pS;
    
    @GetMapping("/get/{userId}")
    public ResponseEntity<ArrayList<Project>> findAllByUserId(@PathVariable("userId") Long userId){
        ArrayList<Project> projects = pS.findAllByUserId(userId);
        if(projects!=null){
            return ResponseEntity.status(HttpStatus.OK).body(projects);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity removeProject(@PathVariable("id") Long id){
        if (pS.removeProject(id)){ 
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
            }
    }
    
    
    @PostMapping("/create/{userId}")
    public ResponseEntity<Project> createProject(@RequestBody Project project, @PathVariable("userId") Long userId) {
        pS.saveProject(project, userId);
        if(project!=null){
            return ResponseEntity.status(HttpStatus.OK).body(project);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/edit/{userId}")
    public ResponseEntity<Project> editProject(@RequestBody Project project, @PathVariable("userId") Long userId) {
        pS.editProject(project, userId);
        if(project!=null){
            return ResponseEntity.status(HttpStatus.OK).body(project);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
}
