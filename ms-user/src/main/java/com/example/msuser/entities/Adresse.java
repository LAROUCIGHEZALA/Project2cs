package com.example.msuser.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Adresse  implements Serializable {
    private String wilaya;
    private String ville;
    private String rue;
}
