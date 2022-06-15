
package com.ap.portfoil.PortfoilBracciale.services;

import com.ap.portfoil.PortfoilBracciale.model.Project;
import com.ap.portfoil.PortfoilBracciale.repositories.ProjectRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository pR;

    public ArrayList<Project> findAllByUserId(Long userId) {
        return pR.getProjectsById(userId);
    }
    
}
