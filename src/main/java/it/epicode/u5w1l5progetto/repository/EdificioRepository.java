package it.epicode.u5w1l5progetto.repository;

import it.epicode.u5w1l5progetto.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
