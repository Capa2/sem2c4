package business.persistence;

import business.entities.*;
import business.exceptions.UserException;

import java.sql.*;

public class QueryMapper {

    private Database database;

    private User user;

    private Carport carport;

    public QueryMapper(Database database) { this.database = database; }

    public void createQuery(Query query) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO Query (userId, carportId, status, message) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, user.getId());
                ps.setInt(2, carport.getId());
                ps.setString(3, query.getStatus());
                ps.setString(4, query.getMessage());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                query.setId(id);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}

//    public User login(String email, String password) throws UserException
//    {
//        try (Connection connection = database.connect())
//        {
//            String sql = "SELECT email, name, phone, phone FROM user WHERE email=? AND password=?";
//
//            try (PreparedStatement ps = connection.prepareStatement(sql))
//            {
//                ps.setString(1, email);
//                ps.setString(2, password);
//                ResultSet rs = ps.executeQuery();
//                if (rs.next())
//                {
//                    String role = rs.getString("role");
//                    int id = rs.getInt("id");
//                    String name = rs.getString("name");
//                    int phone = rs.getInt("phone");
//                    User user = new User(email, password, role, name, phone);
//                    user.setId(id);
//                    return user;
//                } else
//                {
//                    throw new UserException("Could not validate user");
//                }
//            }
//            catch (SQLException ex)
//            {
//                throw new UserException(ex.getMessage());
//            }
//        }
//        catch (SQLException ex)
//        {
//            throw new UserException("Connection to database could not be established");
//        }
//    }
//
//    public void createTown(Town town) throws UserException
//    {
//        try (Connection connection = database.connect())
//        {
//            String sql = "INSERT INTO Town (name) VALUES (?)";
//
//            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
//            {
//                ps.setString(1, town.getTownName());
//                ps.executeUpdate();
//                ResultSet ids = ps.getGeneratedKeys();
//                ids.next();
//                int id = ids.getInt(1);
//                town.setId(id);
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
//}
