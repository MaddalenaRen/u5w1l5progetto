package it.epicode.u5w1l5progetto.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "prenotazioni")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String nome;
    private String cognome;
    private String email;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL) //relazione con prenotazione
    private List<Prenotazione> prenotazioni;

}
