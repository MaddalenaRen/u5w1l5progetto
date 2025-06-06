package it.epicode.u5w1l5progetto.configuration;


import it.epicode.u5w1l5progetto.entities.Edificio;
import it.epicode.u5w1l5progetto.entities.Postazione;
import it.epicode.u5w1l5progetto.entities.Prenotazione;
import it.epicode.u5w1l5progetto.enumaration.TipoPostazione;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("Edificio M1")
    public Edificio getEdificio1(){
        Edificio e1 = new Edificio();
        e1.setNome("Edificio AM1");
        e1.setIndirizzo("Via Roma 21");
        e1.setCitta("Milano");
        e1.setNumeroMaxOccupanti(20);
        return e1;

    }



    @Bean("Edificio R1")
    public Edificio getEdificio2(){
        Edificio e2 = new Edificio();
        e2.setNome("Palazzo R1");
        e2.setIndirizzo("Via Milano 7");
        e2.setCitta("Roma");
        e2.setNumeroMaxOccupanti(2);
        return e2;
    }

    @Bean("Edificio N1")
    public Edificio getEdificio3(){
        Edificio e3 = new Edificio();
        e3.setNome("Palazzo N1");
        e3.setIndirizzo("Via Toledo 7");
        e3.setCitta("Napoli");
        e3.setNumeroMaxOccupanti(5);
        return e3;
    }

    @Bean("POST001")
    public Postazione getPostazione1(@Qualifier("Edificio N1") Edificio edificio3){
        Postazione p1 = new Postazione();
        p1.setDescrizione("Postazione Open Space");
        p1.setTipoPostazione(TipoPostazione.OPEN_SPACE);
        p1.setEdificio(edificio3);
        return p1;
    }

    @Bean("POST002")
    public Postazione getPostazione2(@Qualifier("Edificio R1") Edificio edificio2){
        Postazione p2 =new Postazione();
        p2.setDescrizione("Privato");
        p2.setTipoPostazione(TipoPostazione.PRIVATO);
        p2.setEdificio(edificio2);
        return p2;
    }

    @Bean("POST003")
    public Postazione getPostazione3(@Qualifier("Edificio M1")Edificio edificio1){
        Postazione p3 = new Postazione();
        p3.setDescrizione("Sala Riunioni");
        p3.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        p3.setEdificio(edificio1);


        return p3;

    }

}
