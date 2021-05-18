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

public class QueriesCommand extends CommandUnprotectedPage {
    private CarportFacade carportFacade;
    private QueryFacade queryFacade;


    public QueriesCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        int userId = (int) session.getAttribute("userId");
        String role = (String) session.getAttribute("role");
        ArrayList queries;

        try {
            if (role.equals("customer")) {
                role = "Kunde";
                queries = queryFacade.getQueries(userId);
                request.setAttribute("queries", queries);
            }

            if (role.equals("employee")) {
                role = "Sælger";
                queries = queryFacade.getAllQueries();
                request.setAttribute("queries", queries);
            }

            session.setAttribute("role", role);

            return pageToShow;
        } catch (UserException e) {
            e.printStackTrace();
        }
        return role;
    }
}