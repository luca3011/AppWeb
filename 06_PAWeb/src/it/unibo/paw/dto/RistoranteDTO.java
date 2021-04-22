package it.unibo.paw.dto;

import java.io.Serializable;
import java.util.List;

public class RistoranteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nomeRistorante;
    private String indirizzo;
    private int rating;
    private List<PiattoDTO> piatti;

    public RistoranteDTO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRistorante() {
        return nomeRistorante;
    }

    public void setNomeRistorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<PiattoDTO> getPiatti() {
        return piatti;
    }

    public void setPiatti(List<PiattoDTO> piatti) {
        this.piatti = piatti;
    }

}
