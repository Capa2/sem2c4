package business.persistence;

import business.entities.Color;
import business.entities.Material;
import business.exceptions.UserException;
import org.apache.taglibs.standard.lang.jstl.EnumeratedMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaterialMapper {
    Database database;

    public MaterialMapper(Database database) {
        this.database = database;
    }

    public String getCategory(int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT name FROM `materialcategory` WHERE id = ?";
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

    public Map<Integer, String> getCategories() throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT id, name FROM `materialcategory`";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                Map<Integer, String> categories = new HashMap<>();
                while (rs.next()) {
                    categories.put(rs.getInt("id"), rs.getString("name"));
                }
                return categories;
            }
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
            String sql = "SELECT id, name, cost, length, width FROM `material` WHERE materialCategoryId = ?";

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
                    Material material = new Material(id, width, length, cost, name, categoryId);
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

    public Material getMaterial(int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT name, cost, length, width, materialCategoryId FROM `material` WHERE id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    double cost = rs.getBigDecimal("cost").doubleValue();
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String name = rs.getString("name");
                    int materialCategoryId = rs.getInt("materialCategoryId");
                    Material material = new Material(id, width, length, cost, name, materialCategoryId);
                    material.setColor("black", "#000");
                    return material;
                }
                return null;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public Material getMaterial(String name) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT id, cost, length, width, materialCategoryId FROM `material` WHERE name = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    double cost = rs.getBigDecimal("cost").doubleValue();
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int materialCategoryId = rs.getInt("materialCategoryId");
                    Material material = new Material(id, width, length, cost, name, materialCategoryId);
                    material.setColor("black", "#000");
                    return material;
                }
                return null;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<Material> getAll() throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT id, materialCategoryId, name, cost, length, width FROM `material`";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                List<Material> materials = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    double cost = rs.getBigDecimal("cost").doubleValue();
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String name = rs.getString("name");
                    int materialCategoryId = rs.getInt("materialCategoryId");
                    Material material = new Material(id, width, length, cost, name, materialCategoryId);
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
