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
import javax.websocket.Session;
import java.util.ArrayList;

public class QueryCommand extends CommandProtectedPage {
    private CarportFacade carportFacade;
    private QueryFacade queryFacade;


    public QueryCommand(String pageToShow, String role) {
        super(pageToShow, role);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        int userId = (int) session.getAttribute("userId");
        String userRole = (String) session.getAttribute("role");
        session.setAttribute("role", userRole);
        ArrayList queries;

        try {
            if (request.getParameter("queriedId") != null) {
                int carportId = Integer.parseInt(request.getParameter("queriedId"));
                Carport carport = carportFacade.getCarport(carportId);
                request.setAttribute("carport", carport);

                String status = "Created";
                String message = "Hi this is a query from a customer";

                queryFacade.createQuery(userId, carportId, status, message);
            }

            if (userRole.equals("customer")) {
                queries = queryFacade.getQueries(userId);
                request.setAttribute("queries", queries);
            }

            if (userRole.equals("employee")) {
                queries = queryFacade.getAllQueries();
                request.setAttribute("queries", queries);
            }

            return pageToShow;
        } catch (UserException e) {
            e.printStackTrace();
        }
        return userRole;
    }
}
