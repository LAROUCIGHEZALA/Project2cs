package com.example.msuser;

import com.example.msuser.entities.Adresse;
import com.example.msuser.entities.Compte;
import com.example.msuser.entities.User;
import com.example.msuser.repositories.CompteRepository;
import com.example.msuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication


public class MsUserApplication  implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CompteRepository compteRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

      User u1=userRepository.save(new User(null,"larouci","ghezala","g.larouci@esi-sba.dz","0743456739",

                new Adresse("mascara","tighennif","ville1"),"etudiant",
                Date.valueOf("2000-12-16"),null));
        User u2=userRepository.save(new User(null,"larouci","ghezala","gh.larouci@esi-sba.dz","0743456739",

                new Adresse("mascara","tighennif","ville1"),"etudiant",
                Date.valueOf("2000-12-12"),null));
        Compte c=compteRepository.save(new Compte(null,"g.larouci@esi-sba.dz","pwd",u1));
        Compte c1=compteRepository.save(new Compte(null,"gh.larouci@esi-sba.dz","pwd1",u2));

    }
}
