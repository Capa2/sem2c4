package web.commands;

import business.entities.Carport;
import business.entities.Query;
import business.entities.User;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.QueryFacade;;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class QueryCommand extends CommandUnprotectedPage {
    private CarportFacade carportFacade;
    private QueryFacade queryFacade;

    public QueryCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        int userId = (int) session.getAttribute("userId");
        String role = (String) session.getAttribute("role");

        try {
            if (request.getParameter("queriedId") != null) {
                int carportId = Integer.parseInt(request.getParameter("queriedId"));
                Carport carport = carportFacade.getCarport(carportId);
                request.setAttribute("carport", carport);
                Query query;
            }

            if (role.equals("customer")) {
                role = "Kunde";
                session.setAttribute("role", role);
            }
        } catch (UserException e) {
            e.printStackTrace();
        }
        return role;
    }
}