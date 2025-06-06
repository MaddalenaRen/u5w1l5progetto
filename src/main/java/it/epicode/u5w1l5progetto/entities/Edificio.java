package it.epicode.u5w1l5progetto.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Edificio {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String indirizzo;
    private String citta;
    //

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Postazione> postazioni;
}
