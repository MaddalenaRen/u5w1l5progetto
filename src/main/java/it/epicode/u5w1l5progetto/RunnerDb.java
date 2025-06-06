package it.epicode.u5w1l5progetto;

import it.epicode.u5w1l5progetto.entities.Edificio;
import it.epicode.u5w1l5progetto.entities.Postazione;
import it.epicode.u5w1l5progetto.entities.Prenotazione;
import it.epicode.u5w1l5progetto.entities.Utente;
import it.epicode.u5w1l5progetto.repository.EdificioRepository;
import it.epicode.u5w1l5progetto.repository.PostazioneRepository;
import it.epicode.u5w1l5progetto.repository.PrenotazioneRepository;
import it.epicode.u5w1l5progetto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class RunnerDb implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    @Qualifier("Edificio M1")
    private Edificio edificioM1;

    @Autowired
    @Qualifier("Edificio R1")
    private Edificio edificioR1;

    @Autowired
    @Qualifier("Edificio N1")
    private Edificio edificioN1;

    @Autowired
    @Qualifier("POST001")
    private Postazione postazione1;

    @Autowired
    @Qualifier("POST002")
    private Postazione postazione2;

    @Autowired
    @Qualifier("POST003")
    private Postazione postazione3;



    @Override
    public void run(String... args) throws Exception {

        Edificio savedEdificioM1 = edificioRepository.save(edificioM1);
        Edificio savedEdificioR1 = edificioRepository.save(edificioR1);
        Edificio savedEdificioN1 = edificioRepository.save(edificioN1);

        // Associo gli edifici salvati alle postazioni corrispondenti
        postazione1.setEdificio(savedEdificioN1);
        postazione2.setEdificio(savedEdificioR1);
        postazione3.setEdificio(savedEdificioM1);




        // Salvo le postazioni nel DB
        postazioneRepository.save(postazione1);
        postazioneRepository.save(postazione2);
        Postazione savedP3 = postazioneRepository.save(postazione3);

        Utente utente = new Utente();
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setEmail("mariorossi@email.com");
        utente.setUsername("mario1");
        Utente savedUtente = utenteRepository.save(utente);

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setData(LocalDate.now());
        prenotazione.setPostazione(savedP3);
        //prenotazione.setUtente(utenteRepository.findById(1L).orElseThrow());

        prenotazioneRepository.save(prenotazione);


    }
}
