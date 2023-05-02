package com.example.msuser.API;

import com.example.msuser.entities.Compte;
import com.example.msuser.entities.User;
import com.example.msuser.repositories.CompteRepository;
import com.example.msuser.repositories.UserRepository;
import jakarta.annotation.Resource;
import jakarta.security.auth.message.callback.PasswordValidationCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.InvalidParameterException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("apiuser")
@CrossOrigin(origins = "http://localhost:4200")

public class apiUser {
    @Resource
    UserRepository userRepository;
    @Resource
    private CompteRepository compteRepository;

    @GetMapping("/users/{idU}")
   public  userDTO  getUsers(@PathVariable("idU") Long idU)
    {
        User user= userRepository.findById(idU).get();
        Compte compte=user.getCompte();
        userDTO user1=new userDTO();
        user1.setIdUser(user.getIdUser());
        user1.setFirstName(user.getFirstname());
        user1.setLastName(user.getLastname());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setAdresse(user.getAdresse());
        user1.setRole(user.getRole());
        user1.setDatenaissance(user.getDatenaissance());
        user1.setEmail(compte.getEmail());
        user1.setCompteEmail(compte.getEmail());
        user1.setComptePassword(compte.getPassword());




        return  user1;
    }

    @PutMapping("/{userId}/password")
    public  void updatePassword(@PathVariable Long userId, @RequestParam String oldPassword,  @RequestParam String newPassword) {

        User user = userRepository.findByIdUser(userId);
        Compte compte = user.getCompte();
        //Compte compte= compteRepository.findByEmailAndAndPassword(email,oldPassword);
        if (compte != null && compte.getPassword().equals(oldPassword)) {
            compte.setPassword(String.valueOf(newPassword));
            userRepository.save(user);
            compteRepository.updatePassword(compte.getIdCompte(), String.valueOf(newPassword));

        } else {
            throw new RuntimeException("Wrong username or old password");
        }
    }
}
