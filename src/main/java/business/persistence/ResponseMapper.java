package business.persistence;

import business.entities.*;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResponseMapper {

    private Database database;

    public ResponseMapper(Database database) {
        this.database = database;
    }

    public Response createResponse(Response response) {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO response (querieId, userId, message, price) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, response.getQueryId());
                ps.setInt(2, response.getUserId());
                ps.setString(3, response.getMessage());
                ps.setDouble(4, response.getPrice());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                response.setId(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return response;
    }
}
