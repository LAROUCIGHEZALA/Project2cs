package com.example.msuser.API;

import com.example.msuser.entities.Adresse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


 @AllArgsConstructor @NoArgsConstructor @Data

public class userDTO {

    private Long idUser;
    private String firstName;
    private String lastName;
    private String phone;

    private Adresse adresse;
    private String role;
    private Date datenaissance;
    private String email;
    private String compteEmail;
    private String comptePassword;
}
