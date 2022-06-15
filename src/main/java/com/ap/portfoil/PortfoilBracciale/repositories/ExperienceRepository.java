/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ap.portfoil.PortfoilBracciale.repositories;

import com.ap.portfoil.PortfoilBracciale.model.Experience;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Long>{
    
    @Query(value = "SELECT * FROM experience  WHERE experience.my_user_id = ?1", nativeQuery = true)
    public ArrayList<Experience> getProjectsById(@Param ("1") Long my_user_id);
}
