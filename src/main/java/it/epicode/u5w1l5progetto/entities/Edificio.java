package it.epicode.u5w1l5progetto.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "postazioni")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;
    private int numeroMaxOccupanti;

    //

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Postazione> postazioni;
}
