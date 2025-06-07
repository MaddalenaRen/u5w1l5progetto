package it.epicode.u5w1l5progetto;

import it.epicode.u5w1l5progetto.entities.Postazione;
import it.epicode.u5w1l5progetto.entities.Prenotazione;
import it.epicode.u5w1l5progetto.entities.Utente;
import it.epicode.u5w1l5progetto.enumaration.TipoPostazione;
import it.epicode.u5w1l5progetto.repository.PostazioneRepository;
import it.epicode.u5w1l5progetto.repository.PrenotazioneRepository;
import it.epicode.u5w1l5progetto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class RunnerFunzionalitaUtente implements CommandLineRunner{

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli tipo postazione tra: SALA_RIUNIONI, OPEN_SPACE, PRIVATO");
        String tipoInput = scanner.nextLine();
        //String tipoInput = "PRIVATO";

        System.out.println("Inserisci città tra: Milano, Roma, Napoli");
        String cittaInput = scanner.nextLine();
        //String cittaInput = "Roma";

        System.out.println("Inserisci data yyyy-MM-dd");
        String data = scanner.nextLine();
        //String data = "2025-06-05";
        LocalDate date = LocalDate.parse(data);

        System.out.println("Inserisci username");
        String username = scanner.nextLine();
        //String username = "ilenia";

        boolean isPrenotato = false;

        Utente utente = utenteRepository.findByUsername(username);

        if(utente == null){
            System.out.println("Inserisci nome completo");
            String nome = scanner.nextLine();
            //String nome = "Maddalena Rennella";

            System.out.println("Inserisci email");
            String email = scanner.nextLine();
            //String email = "ilenia@email.com";

            utente = new Utente();

            utente.setNome(nome);
            utente.setEmail(email);
            utente.setUsername(username);

            utenteRepository.save(utente);
        }


        else {
            // Se utente non ha prenotazioni nello stesso giorno
           isPrenotato = prenotazioneRepository.existsByUtenteAndData(utente, date);
        }






        System.out.println("Attendi, sto cercando le postazioni esistenti...");

        if(!isPrenotato){

            try {
                TipoPostazione tipoPostazione = TipoPostazione.valueOf(tipoInput.toUpperCase());
                List<Postazione> risultati = postazioneRepository.findByTipoPostazioneAndEdificio_Citta(tipoPostazione, cittaInput);
                if (risultati.isEmpty()) {
                    System.out.println("Nessuna postazione trovata.");
                } else {
                    risultati.forEach(p -> System.out.println(p.getId()+" - "+ p.getDescrizione() + " in " + p.getEdificio().getCitta()));
                    System.out.println("Scegli una postazione digitando il suo numero");
                    String idPostazione = scanner.nextLine();

                    Postazione postazione = risultati.stream().filter(p -> p.getId() == Long.parseLong(idPostazione)).collect(Collectors.toList()).get(0);

                    if(postazione != null){
                        // Se è disponibile
                        boolean giaPrenotata = prenotazioneRepository.existsByPostazioneAndData(postazione, date);

                        if(!giaPrenotata){
                            // Se edificio è pieno
                            int numeroPrenotazioniEdificio =
                                    prenotazioneRepository.findByPostazione_EdificioAndData(postazione.getEdificio(), date).size();

                            if(numeroPrenotazioniEdificio < postazione.getEdificio().getNumeroMaxOccupanti()){
                                Prenotazione prenotazione = new Prenotazione();
                                prenotazione.setUtente(utente);
                                prenotazione.setData(date);
                                prenotazione.setPostazione(postazione);

                                prenotazioneRepository.save(prenotazione);
                                System.out.println("Prenotazione effettuata.");
                            }
                            else{
                                System.out.println("Mi spiace, numero massimo prenotazioni raggiunto.");
                            }


                        }
                        else {
                            System.out.println("La postazione indicata non è disponibile.");
                        }

                    }
                    else{
                        System.out.println("La postazione indicata non è disponibile.");
                    }

                }
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo postazione non valido. Riprova con: SALA_RIUNIONI, OPEN_SPACE o PRIVATO.");
            }

        }
        else{
            // esci
            System.out.println("Prenotazione già effettuata in data " + data);
        }


        scanner.close();
    }




    }

