package business.persistence;

import business.entities.*;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryMapper {

    private Database database;

    public QueryMapper(Database database) {
        this.database = database;
    }

    public Query createQuery(Query query) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO Query (userId, carportId, status, message) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, query.getUserId());
                ps.setInt(2, query.getCarportId());
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
        return query;
    }

    public List<Query> getQuery(int userId) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "SELECT id, carportId, status, message FROM query WHERE userId=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                List<Query> queries = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int carportId = rs.getInt("carportId");
                    String status = rs.getString("status");
                    String message = rs.getString("message");
                    Query query = new Query(id, userId, carportId, status, message);
                    queries.add(query);
                }
                return queries;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Material> getGroup(int categoryId) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "SELECT carportId, status, message FROM query WHERE userId=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, categoryId);
                ResultSet rs = ps.executeQuery();
                List<Material> materials = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    double cost = rs.getBigDecimal("cost").doubleValue();
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String name = rs.getString("name");
                    Material material = new Material(id, width, length, cost, name);
                    material.setColor("black", "#000");
                    materials.add(material);
                }
                return (materials.size() > 0) ? materials : null;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}
