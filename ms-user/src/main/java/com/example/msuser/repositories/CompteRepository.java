package com.example.msuser.repositories;

import com.example.msuser.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface CompteRepository extends JpaRepository<Compte,Long> {
     Compte findByEmailAndAndPassword(String email,String password);
     @Modifying
     @Query("UPDATE Compte c SET c.password = :newPassword WHERE c.idCompte = :id")
     void updatePassword(@Param("id") Long id, @Param("newPassword") String newPassword);
}
