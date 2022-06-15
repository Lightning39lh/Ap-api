
package com.ap.portfoil.PortfoilBracciale.repositories;

import com.ap.portfoil.PortfoilBracciale.model.Project;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{
    
    @Query(value = "SELECT * FROM project  WHERE project.my_user_id = ?1", nativeQuery = true)
    public ArrayList<Project> getProjectsById(@Param ("1") Long my_user_id);
}
