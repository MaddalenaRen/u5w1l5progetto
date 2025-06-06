package it.epicode.u5w1l5progetto.entities;

import it.epicode.u5w1l5progetto.enumaration.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Postazione {
    @Id
    @GeneratedValue
    private int id;
    private String descrizione;
    private TipoPostazione tipoPostazione;
    private int numeroMaxOccupanti;
    @ManyToOne //una o più post. possono avere un solo edificio
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    private LocalDate data;

    @OneToMany
    private List<Prenotazione> prenotazioni;



}
