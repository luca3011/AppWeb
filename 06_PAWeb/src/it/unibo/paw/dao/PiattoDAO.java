package it.unibo.paw.dao;

import it.unibo.paw.dto.PiattoDTO;

public interface PiattoDAO {

    public void create(PiattoDTO piatto);

    public PiattoDTO read(String nome);

    public boolean update(PiattoDTO piatto);

    public boolean delete(String nome);

    //-------------------------

    public boolean createTable();

    public boolean dropTable();
    
}
