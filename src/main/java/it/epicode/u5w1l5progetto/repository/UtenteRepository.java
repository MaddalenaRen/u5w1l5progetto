package it.epicode.u5w1l5progetto.repository;

import it.epicode.u5w1l5progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository  extends JpaRepository<Utente, Long> {

    public Utente findByUsername (String username);
}
