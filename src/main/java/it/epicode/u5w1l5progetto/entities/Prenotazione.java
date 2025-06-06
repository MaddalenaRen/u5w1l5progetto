package it.epicode.u5w1l5progetto.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate data;
    @ManyToOne
    private Postazione postazione;

    @ManyToOne
    private Utente utente;
}
