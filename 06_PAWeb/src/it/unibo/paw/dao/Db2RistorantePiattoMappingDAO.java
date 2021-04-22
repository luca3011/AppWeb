package it.unibo.paw.dao;

import java.util.List;

import it.unibo.paw.dto.PiattoDTO;

public class Db2RistorantePiattoMappingDAO implements RistorantePiattoMappingDAO {

    //SQL

    static final String TABLE = "ristoranti_piatti";

    static final String ID_R = "idRistorante";
    static final String ID_P = "idPiatto";

    //--------------------

    static final String insert = "INSERT INTO " + TABLE + " ( " + ID_R + ", " + ID_P + " ) VALUES ( ?,? );";

    static String read_by_ids = "SELECT * FROM " + TABLE + " WHERE " + ID_R + " = ? AND " + ID_P + " = ?;";
    
    static String read_by_ristoranteID = "SELECT * FROM " + TABLE + " WHERE " + ID_R + " = ?; ";

    static String read_by_piattoID = "SELECT * FROM " + TABLE + " WHERE " + ID_P + " = ?; ";

    static String read_all = "SELECT * FROM " + TABLE + " ;";

    static String delete = "DELETE FROM " + TABLE + " WHERE " + ID_R + " = ? AND " + ID_P + " = ?;";

    static String create = "CREATE TABLE " + TABLE + " ( " +
                                ID_R + "INT NOT NULL, " +
                                ID_P + "INT NOT NULL, " +
                                "PRIMARY KEY (" + ID_R + "," + ID_P + " ), " +
                                "FOREIGN KEY (" + ID_R + ") REFERENCES ristoranti(id), " +
                                "FOREIGN KEY (" + ID_P + ") REFERENCES piatti(id) " +
                                "); ";

    

    public void create(int idr, int idp) {
        // TODO Auto-generated method stub

    }

    public boolean createTable() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(int idRistorante, int idPiatto) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean dropTable() {
        // TODO Auto-generated method stub
        return false;
    }

    public List<PiattoDTO> getPiattiFromRestaurant(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
