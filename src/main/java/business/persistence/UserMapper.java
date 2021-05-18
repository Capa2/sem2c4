package business.persistence;

import business.entities.Query;
import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper
{
    final private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public void createUser(User user) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO User (phone, email, password, role, name, street, town, zipCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, user.getPhone());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getRole());
                ps.setString(5, user.getName());
                ps.setString(6, user.getStreet());
                ps.setString(7, user.getTown());
                ps.setInt(8, user.getZipCode());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
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

    public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT id, role, name, phone, street, town, zipCode FROM user WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int phone = rs.getInt("phone");
                    String role = rs.getString("role");
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String street = rs.getString("street");
                    String town = rs.getString("town");
                    int zipCode = rs.getInt("zipCode");
                    User user = new User(phone, email, password, role, name, street, town, zipCode);
                    user.setId(id);
                    return user;
                } else
                {
                    throw new UserException("Could not validate user");
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }

    public User getUser(int userId) throws UserException {

        User user = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT phone, zipCode, email, name, street, town FROM user WHERE id=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int phone = rs.getInt("phone");
                    String email = rs.getString("email");
                    String name = rs.getString("name");
                    String street = rs.getString("street");
                    String town = rs.getString("town");
                    int zipCode = rs.getInt("zipCode");
                    user = new User(phone, zipCode, email, name, street, town);
                    return user;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
