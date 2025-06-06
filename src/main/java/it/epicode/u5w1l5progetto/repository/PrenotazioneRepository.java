package it.epicode.u5w1l5progetto.repository;

import it.epicode.u5w1l5progetto.entities.Edificio;
import it.epicode.u5w1l5progetto.entities.Postazione;
import it.epicode.u5w1l5progetto.entities.Prenotazione;
import it.epicode.u5w1l5progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByUtenteAndData(Utente utente, LocalDate data);

    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);

    List<Prenotazione> findByPostazione_EdificioAndData(Edificio edificio, LocalDate date);

}
