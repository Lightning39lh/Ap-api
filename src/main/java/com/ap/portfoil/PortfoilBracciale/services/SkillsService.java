
package com.ap.portfoil.PortfoilBracciale.services;

import com.ap.portfoil.PortfoilBracciale.model.Skill;
import com.ap.portfoil.PortfoilBracciale.repositories.MyUserRepository;
import com.ap.portfoil.PortfoilBracciale.repositories.SkillsRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService {
    @Autowired
    SkillsRepository sR;
    
      @Autowired
    MyUserRepository uR;
    

    public ArrayList<Skill> findAllByUserId(Long userId) {
        return sR.getProjectsById(userId);
    }
    
    public boolean removeSkills(Long id) {
        try {
            sR.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public void saveSkill(Skill skill,Long userId) {
        skill.setMy_user(uR.findById(userId).get());
        
        sR.save(skill);
    }

    public void editSkill(Skill skill,Long userId) {
        skill.setMy_user(uR.findById(userId).get());
        sR.save(skill);
    }
    
}
