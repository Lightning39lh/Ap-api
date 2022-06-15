/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ap.portfoil.PortfoilBracciale.services;

import com.ap.portfoil.PortfoilBracciale.model.Education;
import com.ap.portfoil.PortfoilBracciale.repositories.EducationRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    @Autowired
    EducationRepository eR;

    public ArrayList<Education> findAllByUserId(Long userId) {
        return eR.getProjectsById(userId);
    }
    
}
