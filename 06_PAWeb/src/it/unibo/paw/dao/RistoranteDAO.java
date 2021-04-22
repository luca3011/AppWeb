package it.unibo.paw.dao;

import java.util.List;

import it.unibo.paw.dto.RistoranteDTO;

public interface RistoranteDAO {

    //CRUD

    public void create(RistoranteDTO ristorante);

    public RistoranteDTO read(String nome);

    public boolean update(RistoranteDTO ristorante);

    public boolean delete(String name);

    //-------------------------

    public List<RistoranteDTO> getRestaurantByCity(String citta);

    public List<RistoranteDTO> getRatedRestaurant(int stars);
    
    //--------------------------

    public boolean createTable();

    public boolean dropTable();
    
}
