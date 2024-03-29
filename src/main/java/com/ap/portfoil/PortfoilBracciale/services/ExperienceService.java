
package com.ap.portfoil.PortfoilBracciale.services;

import com.ap.portfoil.PortfoilBracciale.model.Experience;
import com.ap.portfoil.PortfoilBracciale.repositories.ExperienceRepository;
import com.ap.portfoil.PortfoilBracciale.repositories.MyUserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {
    
    @Autowired
    ExperienceRepository eR;
    
    @Autowired
    MyUserRepository uR;

    public ArrayList<Experience> findAllByUserId(Long userId) {
        return eR.getProjectsById(userId);
    }
    
    public boolean removeExperience(Long id) {
        try {
            eR.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void saveExperience(Experience experience,Long userId) {
        experience.setMy_user(uR.findById(userId).get());
        
        eR.save(experience);
    }

    public void editExperience(Experience experience,Long userId) {
        experience.setMy_user(uR.findById(userId).get());
        eR.save(experience);
    }
}
