/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ap.portfoil.PortfoilBracciale.controllers;

import com.ap.portfoil.PortfoilBracciale.model.Link;
import com.ap.portfoil.PortfoilBracciale.services.LinkService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/links")
@CrossOrigin(origins="*")
public class LinkController {
    @Autowired
    LinkService lS;
    
    @GetMapping("/get/{userId}")
    public ResponseEntity<Link> findAllByUserId(@PathVariable("userId") Long userId){
        Link links = lS.findAllByUserId(userId);
        if(links!=null){
            return ResponseEntity.status(HttpStatus.OK).body(links);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PostMapping("/edit/{userId}")
    public ResponseEntity<Link> editProject(@RequestBody Link link, @PathVariable("userId") Long userId) {
        System.out.println(link);
        lS.editLink(link, userId);
        if(link!=null){
            return ResponseEntity.status(HttpStatus.OK).body(link);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
