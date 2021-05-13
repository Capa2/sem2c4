package business.persistence;

import business.entities.Color;
import business.entities.Material;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialMapper {
    Database database;

    public MaterialMapper(Database database) {
        this.database = database;
    }

    public String getCategory(int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT name FROM materialCategory WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString(1);
                }
            }
            return null;
        } catch (SQLException ex) {
            throw new UserException("Could not get material categories");
        }
    }

    public List<Color> getColors(int materialId) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT id, name, hexcode FROM materialColor WHERE materialId = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialId);
                ResultSet rs = ps.executeQuery();
                List<Color> colors = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String hexcode = rs.getString("hexcode");
                    Color color = new Color(id, name, hexcode);
                    colors.add(color);
                }
                return (colors.size() > 0) ? colors : null;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<Material> getGroup(int categoryId) throws UserException {
        String category = getCategory(categoryId);

        try (Connection connection = database.connect()) {
            String sql = "SELECT id, name, cost, length, width FROM material WHERE materialCategoryId = ?";

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

    public List<Material> getAll() throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT id, materialCategoryId, name, cost, length, width FROM material";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
