package com.ap.portfoil.PortfoilBracciale.services;


import com.ap.portfoil.PortfoilBracciale.model.MyUser;
import com.ap.portfoil.PortfoilBracciale.model.Role;
import com.ap.portfoil.PortfoilBracciale.repositories.MyUserRepository;
import com.ap.portfoil.PortfoilBracciale.repositories.RoleRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {
    
    @Autowired
    MyUserRepository uR;
    
    @Autowired
    RoleRepository rRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ArrayList<MyUser> getAllUsers() {
        return (ArrayList<MyUser>) uR.findAll();
    }

    public MyUser saveUser(MyUser user) {
        //TRAIGO EL ROL
        Optional<Role> rol = rRepository.findByName("ROLE_USER"); 
        Role rols = rol.get();

        //SETEO EL ROL
        user.setRole(rols);
        //HASH PASSWORD
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("nada");
        //RETORNO EL USER
        uR.save(user);
        return user;
    }

    public Optional<MyUser> getUserByID(Long id) {
        return uR.findById(id);
    }


    public Long findByUsername(String username)
    {
       MyUser u = uR.findByUsername(username).get();
       Long id = u.getId();
        if(id != null)
        {
            return id;
        }
        else
        return null;

    }

    //DELETE
    public boolean deleteById(Long id) {
        try {
            uR.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    //EDIT
    public boolean editByUserName(MyUser user) {
        if (uR.findById(user.getId()) != null){
            uR.save(user);
            return true;
        } else
            return false;        
    }
    
    
}
