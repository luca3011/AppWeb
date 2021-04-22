package it.unibo.paw.dto;

import java.io.Serializable;

public class PiattoDTO implements Serializable {

    private String nomePiatto;
    private String tipo;
    private int id;

    public PiattoDTO() {
        super();
    }

    public String getNomePiatto() {
        return nomePiatto;
    }

    public void setNomePiatto(String nomePiatto) {
        this.nomePiatto = nomePiatto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
