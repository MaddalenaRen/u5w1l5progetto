package it.epicode.u5w1l5progetto.entities;

import it.epicode.u5w1l5progetto.enumaration.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"edificio", "prenotazioni"})
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;


    @ManyToOne //una o più post. possono avere un solo edificio
    @JoinColumn(name = "edificio_id") //relazione con Edificio
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni; //relazione con Prenotazione



}
