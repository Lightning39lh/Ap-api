
package com.ap.portfoil.PortfoilBracciale.services;

import com.ap.portfoil.PortfoilBracciale.model.Link;
import com.ap.portfoil.PortfoilBracciale.repositories.MyUserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ap.portfoil.PortfoilBracciale.repositories.LinkRepository;

@Service
public class LinkService {
    
    @Autowired
    LinkRepository lR;
    
    @Autowired
    MyUserRepository uR;
    

    public Link findAllByUserId(Long userId) {
        return lR.getLinksById(userId);
    }
    public void saveLink(Link link,Long userId) {
        link.setMy_user(uR.findById(userId).get());
        System.out.println(link);
        lR.save(link);
    }

    public void editLink(Link link,Long userId) {
        link.setMy_user(uR.findById(userId).get());
        lR.save(link);
    }
}
