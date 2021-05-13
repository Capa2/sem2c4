package business.services;

import business.entities.Color;
import business.entities.Material;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.MaterialMapper;

import java.util.List;

public class MaterialFacade {
    MaterialMapper materialMapper;

    public MaterialFacade(Database database) {
        materialMapper = new MaterialMapper(database);
    }

    public String getCategory(int categoryId) throws UserException {
        // Get the category name
        return materialMapper.getCategory(categoryId);
    }

    public List<Color> getColors(int materialId) throws UserException {
        // get a list of available colors for any given material
        return materialMapper.getColors(materialId);
    }

    public List<Material> getGroup(int categoryId) throws UserException {
        // Get a list of materials in a specific category
        return materialMapper.getGroup(categoryId);
    }

    public List<Material> getAll() throws UserException {
        // Get a list of all materials
        return materialMapper.getAll();
    }

    // TODO INSERT TAGGED MATERIAL METHOD

}
