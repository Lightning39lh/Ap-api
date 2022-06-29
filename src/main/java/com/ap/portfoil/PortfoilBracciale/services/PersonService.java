
package com.ap.portfoil.PortfoilBracciale.services;

import com.ap.portfoil.PortfoilBracciale.model.Person;
import com.ap.portfoil.PortfoilBracciale.repositories.PersonRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository pR;

    public Person findAllByUserId(Long userId) {
        return pR.getPersonById(userId);
    }
}
