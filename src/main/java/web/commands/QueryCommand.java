package web.commands;

import business.entities.Carport;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.QueryFacade;;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QueryCommand extends CommandProtectedPage {
    private CarportFacade carportFacade;
    private QueryFacade queryFacade;



    public QueryCommand(String pageToShow, String role) {
        super(pageToShow, role);
        carportFacade = new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            int carportId = Integer.parseInt(request.getParameter("queriedId"));
            Carport carport = carportFacade.getCarport(carportId);
            request.setAttribute("carport", carport);
        } catch (UserException e) {
            e.printStackTrace();
        }





        return pageToShow;
    }
}
