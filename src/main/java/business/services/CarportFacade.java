package business.services;

import business.entities.Carport;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;

import java.util.List;

public class CarportFacade {
    CarportMapper carportMapper;

    public CarportFacade(Database database) {
        carportMapper = new CarportMapper(database);
    }

    public void createCarport(int roofAngle, int width, int length, int shedwidth, int shedlength) throws UserException {
        createCarport(new Carport(roofAngle, width, length, shedwidth, shedlength));
    }

    public void createCarport(Carport carport) throws UserException {
        Carport c = carportMapper.createCarport(carport);
    }
    public Carport createGetCarport(Carport carport) throws UserException {
        return carportMapper.createCarport(carport);
    }

    public Carport getCarport(int id) throws UserException {
        return carportMapper.getCarport(id);
    }

    public List<Carport> getModels() throws UserException {
        return carportMapper.getModels();
    }
}
