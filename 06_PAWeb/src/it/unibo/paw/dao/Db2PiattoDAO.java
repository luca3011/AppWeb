package it.unibo.paw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.paw.dto.PiattoDTO;

public class Db2PiattoDAO implements PiattoDAO {

    static final String TABLE = "piatti";

    static final String ID_P = "id";
    static final String NOME = "nome";
    static final String TIPO = "tipo";

    //----------------------------------

    static final String drop = "DROP TABLE " + TABLE + " ";

    static String read_all = "SELECT * FROM " + TABLE + " ;";

    static String create = "CREATE TABLE " + TABLE + " ( " + ID_P + "INT NOT NULL PRIMARY KEY, " + TIPO + "VARCHAR(20) NOT NULL, " + NOME + "VARCHAR(30) NOT NULL );";

    static String insert = "INSERT INTO " + TABLE + " ( " + ID_P + ", " + TIPO + ", " + NOME + " ) VALUES ( ?,?,? );";

    static String query_name = "SELECT * FROM " + TABLE + " WHERE " + NOME + " =?;";

    static String delete = "DELETE FROM " + TABLE + " WHERE " + NOME + " =?;"; 

    public Db2PiattoDAO() {
        super();
    }

    public void create(PiattoDTO piatto) {

        Connection conn = Db2DAOFactory.createConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement(insert);
            
            stmt.setInt(1, piatto.getId());
            stmt.setString(2, piatto.getTipo());
            stmt.setString(3, piatto.getNomePiatto());

            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                if (stmt != null)
                {
                    stmt.close();
                }
                if (conn!=null)
                {
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }

    public PiattoDTO read(String nome) {

        PiattoDTO result = null;

        Connection conn = Db2DAOFactory.createConnection();
        try {
            PreparedStatement prep_stmt = conn.prepareStatement(query_name);
            prep_stmt.clearParameters();
            prep_stmt.setString(1, nome);
            ResultSet res = prep_stmt.executeQuery();

            result = new PiattoDTO();

            if( res.next() ){
                result.setId(res.getInt("id"));
                result.setNomePiatto(res.getString("nome"));
                result.setTipo(res.getString("tipo"));
            }

            res.close();
            prep_stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            Db2DAOFactory.closeConnection(conn);
        }

        return result;

    }

    public boolean update(PiattoDTO piatto) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(String nome) {
        Connection conn = Db2DAOFactory.createConnection();
        PreparedStatement stmt = null;
        boolean result = true;

        try{
            stmt = conn.prepareStatement(insert);
            
            stmt.setString(1, nome);
            

            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            result = false;
        }
        finally
        {
            try{
                if (stmt != null)
                {
                    stmt.close();
                }
                if (conn!=null)
                {
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                result = false;
            }
        }

        return result;
    }

    public boolean createTable() {
        Connection conn = Db2DAOFactory.createConnection();
        PreparedStatement stmt = null;
        boolean result = true;

        try{
            stmt = conn.prepareStatement(create);
            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            result = false;
        }
        finally
        {
            try{
                if (stmt != null)
                {
                    stmt.close();
                }
                if (conn!=null)
                {
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                result = false;
            }
        }

        return result;
    }
    

    public boolean dropTable() {

        Connection conn = Db2DAOFactory.createConnection();
        PreparedStatement stmt = null;
        boolean result = true;

        try{
            stmt = conn.prepareStatement(drop);
            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            result = false;
        }
        finally
        {
            try{
                if (stmt != null)
                {
                    stmt.close();
                }
                if (conn!=null)
                {
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                result = false;
            }
        }

        return result;
    }

}
