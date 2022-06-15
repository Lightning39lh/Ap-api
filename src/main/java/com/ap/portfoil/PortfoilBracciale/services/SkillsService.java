
package com.ap.portfoil.PortfoilBracciale.services;

import com.ap.portfoil.PortfoilBracciale.model.Skill;
import com.ap.portfoil.PortfoilBracciale.repositories.SkillsRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService {
    @Autowired
    SkillsRepository sR;

    public ArrayList<Skill> findAllByUserId(Long userId) {
        return sR.getProjectsById(userId);
    }
}
