package it.epicode.u5w1l5progetto.repository;

import it.epicode.u5w1l5progetto.entities.Postazione;
import it.epicode.u5w1l5progetto.enumaration.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoPostazioneAndEdificio_Citta(TipoPostazione tipo,String citta);
}
