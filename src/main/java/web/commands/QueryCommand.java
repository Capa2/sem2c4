package web.commands;

import business.entities.Carport;
import business.entities.Query;
import business.entities.User;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.QueryFacade;
import business.services.QuickBuilder;
import business.services.UserFacade;;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class QueryCommand extends CommandUnprotectedPage {
    private CarportFacade carportFacade;
    private QueryFacade queryFacade;
    private UserFacade userFacade;
    private QuickBuilder quickBuilder;
    private Carport carport;

    public QueryCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
        userFacade = new UserFacade(database);
        quickBuilder = new QuickBuilder();

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("userFacade", userFacade);

        if (request.getParameter("submit") != null) {
            carport = carportFacade.createGetCarport(quickBuilder.getCarport(request));
        } else {
            int id = Integer.parseInt(request.getParameter("queriedId"));
            carport = carportFacade.getCarport(id);
        }

        String wantBuilder = request.getParameter("wantBuilder");

        int userId = (int) session.getAttribute("userId");
        String role = (String) session.getAttribute("role");
        Query query = new Query(user.getId(), carport.getId(), "Xreated", "Robotmachine", wantBuilder); // add wantbuilder

        return pageToShow;
    }
}