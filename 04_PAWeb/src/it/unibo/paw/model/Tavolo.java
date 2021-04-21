package it.unibo.paw.model;

import java.util.Set;

public class Tavolo {

    private int idTavolo;
    private String numeroTavolo;
    private int capienzaTavolo;
    private Set<PrenotazioneRistorante> prenotazioniTavolo;
    
    public Tavolo(int idTavolo, String numeroTavolo, int capienzaTavolo,
            Set<PrenotazioneRistorante> prenotazioniTavolo) {
        this.idTavolo = idTavolo;
        this.numeroTavolo = numeroTavolo;
        this.capienzaTavolo = capienzaTavolo;
        this.prenotazioniTavolo = prenotazioniTavolo;
    }

    public int getIdTavolo() {
        return idTavolo;
    }

    public void setIdTavolo(int idTavolo) {
        this.idTavolo = idTavolo;
    }

    public String getNumeroTavolo() {
        return numeroTavolo;
    }

    public void setNumeroTavolo(String numeroTavolo) {
        this.numeroTavolo = numeroTavolo;
    }

    public int getCapienzaTavolo() {
        return capienzaTavolo;
    }

    public void setCapienzaTavolo(int capienzaTavolo) {
        this.capienzaTavolo = capienzaTavolo;
    }

    public Set<PrenotazioneRistorante> getPrenotazioniTavolo() {
        return prenotazioniTavolo;
    }

    public void setPrenotazioniTavolo(Set<PrenotazioneRistorante> prenotazioniTavolo) {
        this.prenotazioniTavolo = prenotazioniTavolo;
    }

    
    
}
