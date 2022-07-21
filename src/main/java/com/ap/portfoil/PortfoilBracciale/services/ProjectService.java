
package com.ap.portfoil.PortfoilBracciale.services;

import com.ap.portfoil.PortfoilBracciale.model.Project;
import com.ap.portfoil.PortfoilBracciale.repositories.MyUserRepository;
import com.ap.portfoil.PortfoilBracciale.repositories.ProjectRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository pR;
    @Autowired
    MyUserRepository uR;
    

    public ArrayList<Project> findAllByUserId(Long userId) {
        return pR.getProjectsById(userId);
    }
    public boolean removeProject(Long id) {
        try {
            pR.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void saveProject(Project project,Long userId) {
        project.setMy_user(uR.findById(userId).get());
        System.out.println(project);
        
        pR.save(project);
    }

    public void editProject(Project project,Long userId) {
        project.setMy_user(uR.findById(userId).get());
        pR.save(project);
    }
}
