
package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.Project;
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
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService pS;
    
    @GetMapping("/{userId}")
    public ResponseEntity<ArrayList<Project>> findAllByUserId(@PathVariable("userId") Long userId){
        ArrayList<Project> projects = pS.findAllByUserId(userId);
        if(projects!=null){
            return ResponseEntity.status(HttpStatus.OK).body(projects);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
