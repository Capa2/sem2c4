package business.services;

import business.entities.Color;
import business.entities.Material;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.MaterialMapper;

import java.util.List;
import java.util.Map;

public class MaterialFacade {
    MaterialMapper materialMapper;

    public MaterialFacade(Database database) {
        materialMapper = new MaterialMapper(database);
    }

    public Material getMaterial(int id) throws UserException {
        // Get a single material item
        return materialMapper.getMaterial(id);
    }
    public Material getMaterial(String name) throws UserException {
        // Get a single material item
        return materialMapper.getMaterial(name);
    }
    public List<Material> getGroup(int categoryId) throws UserException {
        // Get a list of materials in a specific category
        return materialMapper.getGroup(categoryId);
    }

    public List<Material> getAll() throws UserException {
        // Get a list of all materials
        return materialMapper.getAll();
    }
    public String getCategory(int categoryId) throws UserException {
        // Get the category name
        return materialMapper.getCategory(categoryId);
    }

    public Map<Integer, String> getCategories() throws UserException {
        return materialMapper.getCategories();
    }

    public List<Color> getColors(int materialId) throws UserException {
        // get a list of available colors for any given material
        return materialMapper.getColors(materialId);
    }
    
    // TODO INSERT TAGGED MATERIAL METHOD

}
