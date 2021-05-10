package business.persistence;

import business.entities.Carport;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper {
    private Database database;

    public CarportMapper(Database database) {
        this.database = database;
    }

    public void createCarport(Carport carport) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO Carport (roofAngle, width, length, shedwidth, shedlength) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, carport.getRoofAngle());
                ps.setInt(2, carport.getWidth());
                ps.setInt(3, carport.getLength());
                ps.setInt(4, carport.getShedWidth());
                ps.setInt(5, carport.getShedLength());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                carport.setId(id);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public Carport getCarport(int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "roofAngle, width, length, shedwidth, shedlength, name FROM carport WHERE id == ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int roofAngle = rs.getInt("roofAngle");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    int shedWidth = rs.getInt("shedwidth");
                    int shedLength = rs.getInt("shedlength");
                    Carport carport = new Carport(id, roofAngle, width, length, shedWidth, shedLength);
                    try {
                        String name = rs.getString("name");
                        carport.setName(name);
                    } catch (NullPointerException ex) {
                        throw new RuntimeException(ex); // continues
                    } finally {
                        return carport;
                    }
                }
                return null;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<Carport> getModels() throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT id, roofAngle, width, length, shedwidth, shedlength, name FROM carport WHERE name IS NOT NULL";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                List<Carport> carpotList = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int roofAngle = rs.getInt("roofAngle");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    int shedWidth = rs.getInt("shedwidth");
                    int shedLength = rs.getInt("shedlength");
                    String name = rs.getString("name");
                    Carport carport = new Carport(id, name, roofAngle, width, length, shedWidth, shedLength);
                    carpotList.add(carport);
                }
                return carpotList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}
