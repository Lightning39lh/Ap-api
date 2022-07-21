
package com.ap.portfoil.PortfoilBracciale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "link")
public class Link {
     @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String linkedin;
    private String github;
    @ManyToOne
    @JoinColumn(name = "My_User_Id")
    private MyUser my_user;
}
