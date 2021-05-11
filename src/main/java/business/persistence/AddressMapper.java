package business.persistence;

import business.entities.Address;
import business.entities.Carport;
import business.entities.PostalCode;
import business.entities.Town;
import business.exceptions.UserException;

import java.sql.*;

public class AddressMapper {

    private Database database;

    public AddressMapper(Database database)
    {
        this.database = database;
    }

    public void createAddress(Address address) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO Address (address) VALUES (?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, address.getName());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                address.setId(id);
                //TownId from Town.getTownId creating method later and will ise it
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public void createTown(Town town) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO Town (name) VALUES (?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, town.getName());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                town.setId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

//    public Carport getAddress(int id) throws UserException
//    {
//
//        try (Connection connection = database.connect())
//        {
//            Address address = null;
//            int addressId = address.getId();
//
//            String sql = "SELECT name FROM address WHERE id = addressId";
//
//            try (PreparedStatement ps = connection.prepareStatement(sql))
//            {
//                ps.setInt(1, id);
//                ResultSet rs = ps.executeQuery();
//                String name = rs.getString("name");
//                address.setName(name);
//                }
//                return null;
//            } catch (SQLException ex) {
//                throw new UserException(ex.getMessage());
//            }
//        } catch (SQLException ex) {
//            throw new UserException("Connection to database could not be established");
//        }
//    }

//    public void createPostalCode(PostalCode postalCode) throws UserException
//    {
//        try (Connection connection = database.connect())
//        {
//            String sql = "INSERT INTO PostalCode (name) VALUES (?)";
//
//            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
//            {
//                ps.setString(1, postalCode.getName());
//                ps.executeUpdate();
//                ResultSet ids = ps.getGeneratedKeys();
//                ids.next();
//                int id = ids.getInt(1);
//                postalCode.setId(id);
//            }
//            catch (SQLException ex)
//            {
//                throw new UserException(ex.getMessage());
//            }
//        }
//        catch (SQLException ex)
//        {
//            throw new UserException(ex.getMessage());
//        }
//    }
}
