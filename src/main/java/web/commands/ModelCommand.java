package web.commands;

import business.entities.Carport;
import business.services.CarportFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModelCommand extends CommandUnprotectedPage {
    private CarportFacade carportFacade;

    public ModelCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int carportId = Integer.parseInt(request.getParameter("model"));
        Carport carport = carportFacade.getCarport(carportId);
        request.setAttribute("carport", carport);

//        Query query = QueryFacade.createQuery(get_userID, user_name, carport_name);
//        session.setAttribute("carport", carport);
//        Carport carport = (Carport) request.getAttribute("carport");
//        session.setAttribute("carport_id", carport_id);

        return pageToShow;
    }
}