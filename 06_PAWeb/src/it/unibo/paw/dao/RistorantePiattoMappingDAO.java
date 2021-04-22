package it.unibo.paw.dao;

import java.util.List;

import it.unibo.paw.dto.PiattoDTO;

public interface RistorantePiattoMappingDAO {

    //CRUD

    public void create(int idr, int idp);

    public boolean delete(int idRistorante, int idPiatto);

    //------------------

    public List<PiattoDTO> getPiattiFromRestaurant(int id);

    //--------------

    public boolean createTable();

    public boolean dropTable();
    
}
