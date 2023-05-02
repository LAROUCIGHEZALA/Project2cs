package com.example.msuser.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(nullable = false, length = 20)

    private String firstname;
    @Column(nullable = false, length = 20)
    private String lastname;
    @Column(unique = true)
    private  String email;
    private String phone;
    @Nullable
    @Embedded
    private  Adresse adresse;
    private String role;
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private  Compte compte;
}
