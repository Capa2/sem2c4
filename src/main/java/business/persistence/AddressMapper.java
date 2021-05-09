package business.persistence;

import business.entities.Address;
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
                ps.setString(1, address.getAddress());
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
}
