package web.commands;

import business.entities.Carport;
import business.services.BomGenerator;
import business.services.CarportFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModelCommand extends CommandUnprotectedPage {
    final private CarportFacade carportFacade;
    final private BomGenerator bomGenerator;

    public ModelCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        bomGenerator = new BomGenerator(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        try {
            int carportId = Integer.parseInt(request.getParameter("model"));
            Carport carport = carportFacade.getCarport(carportId);
            request.setAttribute("carport", carport);
            request.setAttribute("bom", bomGenerator.getBom(carportId));
        } catch (UserException e) {
            e.printStackTrace();
        }

        return pageToShow;
    }
}