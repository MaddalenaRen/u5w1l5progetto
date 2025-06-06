package it.epicode.u5w1l5progetto.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Utente {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String nome;
    private String cognome;
    private String email;

    @OneToMany
    private List<Prenotazione> prenotazioni;

}
