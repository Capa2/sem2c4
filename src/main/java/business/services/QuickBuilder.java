package business.services;

import business.entities.Carport;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;

public class QuickBuilder {

    public QuickBuilder() {
    }

    public Carport getCarport(HttpServletRequest request) throws UserException {
        int roofAngle = request.getParameter("roof").equals("flat") ? 0 : 45;
        try {
            int width =         Integer.parseInt(request.getParameter("width"));
            int length =        Integer.parseInt(request.getParameter("length"));
            int shedWidth =     Integer.parseInt(request.getParameter("shedWidth"));
            int shedLength =    Integer.parseInt(request.getParameter("shedLength"));
            return new Carport(roofAngle, width, length, shedWidth, shedLength);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            throw new UserException("Fejl i quick byg carport.");
        }

    }

}
