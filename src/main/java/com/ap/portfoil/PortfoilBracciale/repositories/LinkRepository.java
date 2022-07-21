
package com.ap.portfoil.PortfoilBracciale.repositories;

import com.ap.portfoil.PortfoilBracciale.model.Link;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LinkRepository extends JpaRepository<Link,Long>{
    
    
    @Query(value = "SELECT * FROM link  WHERE link.my_user_id = ?1", nativeQuery = true)
    public Link getLinksById(@Param ("1") Long my_user_id);
    
}
