package it.unibo.paw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unibo.paw.dto.PiattoDTO;

public class Db2RistorantePiattoMappingDAO implements RistorantePiattoMappingDAO {

    // SQL

    static final String TABLE = "ristoranti_piatti";

    static final String ID_R = "idRistorante";
    static final String ID_P = "idPiatto";

    // --------------------

    static final String insert = "INSERT INTO " + TABLE + " ( " + ID_R + ", " + ID_P + " ) VALUES ( ?,? );";

    static final String drop = "DROP TABLE " + TABLE + " ";

    static String read_by_ids = "SELECT * FROM " + TABLE + " WHERE " + ID_R + " = ? AND " + ID_P + " = ?;";

    static String read_by_ristoranteID = "SELECT * FROM " + TABLE + " WHERE " + ID_R + " = ?; ";

    static String read_by_piattoID = "SELECT * FROM " + TABLE + " WHERE " + ID_P + " = ?; ";

    static String read_all = "SELECT * FROM " + TABLE + " ;";

    static String delete = "DELETE FROM " + TABLE + " WHERE " + ID_R + " = ? AND " + ID_P + " = ?;";

    static String dish_query = "SELECT * FROM " + TABLE + " RP, piatti P WHERE RP." + ID_P + " = P.id AND " + ID_R
            + " = ?;";

    static String create = "CREATE TABLE " + TABLE + " ( " + ID_R + "INT NOT NULL, " + ID_P + "INT NOT NULL, "
            + "PRIMARY KEY (" + ID_R + "," + ID_P + " ), " + "FOREIGN KEY (" + ID_R + ") REFERENCES ristoranti(id), "
            + "FOREIGN KEY (" + ID_P + ") REFERENCES piatti(id) " + "); ";

    public Db2RistorantePiattoMappingDAO() {
        super();
    }

    public void create(int idr, int idp) {

        Connection conn = Db2DAOFactory.createConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement(insert);
            stmt.setInt(1, idr);
            stmt.setInt(2, idp);

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

    public boolean createTable() {
        Connection connection = null;
		PreparedStatement statement = null;
        boolean result = false;

		try {
			connection = Db2DAOFactory.createConnection();
			statement = connection.prepareStatement(create);
		

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null) {
					connection.close();
					connection = null;
				}
                result = true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

        return result;
    }

    public boolean delete(int idRistorante, int idPiatto) {
        Connection connection = null;
		PreparedStatement statement = null;
        boolean result = false;

		try {
			connection = Db2DAOFactory.createConnection();
			statement = connection.prepareStatement(delete);
		

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null) {
					connection.close();
					connection = null;
				}
                result = true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

        return result;
    }

    public boolean dropTable() {
        Connection connection = null;
		PreparedStatement statement = null;
        boolean result = false;

		try {
			connection = Db2DAOFactory.createConnection();
			statement = connection.prepareStatement(drop);
			
            //statement.setInt(1, id);...

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null) {
					connection.close();
					connection = null;
				}
                result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

        return result;
    }

    public List<PiattoDTO> getPiattiFromRestaurant(int id) {

        List<PiattoDTO> result = null;
        if (id < 0) {
            System.out.println("read(): cannot read an entry with negative id");
            return result;
        }
        Connection conn = Db2DAOFactory.createConnection();
        try {
            PreparedStatement prep_stmt = conn.prepareStatement(dish_query);
            prep_stmt.clearParameters();
            prep_stmt.setInt(1, id);
            ResultSet res = prep_stmt.executeQuery();

            result = new ArrayList<PiattoDTO>();

            while( res.next() ){
                PiattoDTO entry = new PiattoDTO();
                entry.setId(res.getInt("id"));
                entry.setNomePiatto(res.getString("nome"));
                entry.setTipo(res.getString("tipo"));
                result.add(entry);
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

    /* public void ...(int id) throws PersistenceException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = Db2DAOFactory.createConnection();
			statement = connection.prepareStatement(...);
			
            //statement.setInt(1, id);...

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	} */


}
