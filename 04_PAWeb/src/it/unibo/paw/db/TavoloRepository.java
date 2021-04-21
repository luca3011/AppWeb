package it.unibo.paw.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TavoloRepository {

    private DataSource dataSource;

    private static final String TABLE = "tavolo";

    private static final String ID = "id";
    private static final String NUMERO = "numero";

    static String read_avaible_table = "SELCECT " + NUMERO + " FROM " + TABLE + " WHERE capienza >= ? AND " + ID
            + "NOT IN ( SELECT idTavolo FROM prenotazione WHERE data = ?)";

    String DisponibilitaTavolo(Date data, int numeroPersone)
    {
        String result = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = this.dataSource.getConnection();
            statement = connection.prepareStatement(read_avaible_table);
            statement.setInt(1, numeroPersone);
            statement.setDate(2, data);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                result = rs.getString(NUMERO);
            }
            else
                result = null;
            return result;
        }catch (SQLException e){
            throw new PersistenceException(e.getMessage());
        }
        finally{
            try {
                if (statement != null)
                    statement.close();
                if(connection != null)
                {
                    connection.close();
                    connection = null;
                }

            }
            catch(SQLException e) {
                throw new PersistenceException(e.getMessage());
            }
        }


    }

}
