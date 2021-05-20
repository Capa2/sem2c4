package web.commands;

import business.entities.Carport;
import business.entities.Query;
import business.entities.User;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.QueryFacade;
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


    public QueryCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
        userFacade = new UserFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int carportId = Integer.parseInt(request.getParameter("queriedId"));
        Carport carport = carportFacade.getCarport(carportId);
        System.out.println(carport);
        request.setAttribute("userFacade", userFacade);
//        id, roofAngle, width, length, shedWidth, shedLength

        int userId = (int) session.getAttribute("userId");
        String role = (String) session.getAttribute("role");
        ArrayList<Query> queries = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        Query query = new Query(userId, carportId, "Xreated", "Robotmachine");

        try {
            if (role.equals("customer") || role.equals("Kunde")) {
                role = "Kunde";
                queryFacade.createQuery(userId, carport.getId(), "Xreated", "Robotmachine");
                queries = queryFacade.getQueries(userId);
                request.setAttribute("queries", queries);
                session.getAttribute("user");
            }

            if (role.equals("employee") || role.equals("Sælger")) {
                role = "Sælger";
                request.getAttribute("queries");
            }

            session.setAttribute("role", role);

            return pageToShow;
        } catch(UserException e){
            e.printStackTrace();
        }
        return role;
    }
}