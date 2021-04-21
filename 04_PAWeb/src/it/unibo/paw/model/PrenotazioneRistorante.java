package it.unibo.paw.model;

import java.util.Date;

public class PrenotazioneRistorante {
    
    private int idPrenotazione;
    private String cognomePrentazione;
    private Date dataPrenotazione;
    private int numeroPersonePrenotazione;
    private String cellularePrenotazione;
    private int idTavoloPrenotazione;
    
    public PrenotazioneRistorante(int idPrenotazione, String cognomePrentazione, Date dataPrenotazione, int numeroPersonePrenotazione, String cellularePrenotazione, int idTavoloPrenotazione) {
        this.idPrenotazione = idPrenotazione;
        this.cognomePrentazione = cognomePrentazione;
        this.dataPrenotazione = dataPrenotazione;
        this.numeroPersonePrenotazione = numeroPersonePrenotazione;
        this.cellularePrenotazione = cellularePrenotazione;
        this.idTavoloPrenotazione = idTavoloPrenotazione;
    }

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public String getCognomePrentazione() {
        return cognomePrentazione;
    }

    public void setCognomePrentazione(String cognomePrentazione) {
        this.cognomePrentazione = cognomePrentazione;
    }

    public Date getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(Date dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public int getNumeroPersonePrenotazione() {
        return numeroPersonePrenotazione;
    }

    public void setNumeroPersonePrenotazione(int numeroPersonePrenotazione) {
        this.numeroPersonePrenotazione = numeroPersonePrenotazione;
    }

    public String getCellularePrenotazione() {
        return cellularePrenotazione;
    }

    public void setCellularePrenotazione(String cellularePrenotazione) {
        this.cellularePrenotazione = cellularePrenotazione;
    }

    public int getIdTavoloPrenotazione() {
        return idTavoloPrenotazione;
    }

    public void setIdTavoloPrenotazione(int idTavoloPrenotazione) {
        this.idTavoloPrenotazione = idTavoloPrenotazione;
    }
    
    
    

}
