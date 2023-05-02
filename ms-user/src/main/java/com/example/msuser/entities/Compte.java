package com.example.msuser.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "compte")

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // Define the one-to-one relationship with the "user" table
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
