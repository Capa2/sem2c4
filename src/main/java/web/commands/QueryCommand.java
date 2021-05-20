package web.commands;

import business.entities.Bom;
import business.entities.Carport;
import business.entities.Query;
import business.entities.User;
import business.exceptions.UserException;
import business.services.BomBuilder;
import business.services.CarportFacade;
import business.services.QueryFacade;
import business.services.UserFacade;
import business.services.QuickBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class QueryCommand extends CommandUnprotectedPage {
    final private CarportFacade carportFacade;
    final private QueryFacade queryFacade;
    final private UserFacade userFacade;
    final private BomBuilder bomBuilder;
    final private QuickBuilder quickBuilder;
    private Carport carport;


    public QueryCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
        userFacade = new UserFacade(database);
        bomBuilder = new BomBuilder(database);
        quickBuilder = new QuickBuilder();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (request.getParameter("submit") != null) {
            carport = carportFacade.createGetCarport(quickBuilder.getCarport(request));
        } else {
            int id = Integer.parseInt(request.getParameter("queriedId"));
            carport = carportFacade.getCarport(id);
        }
        String wantBuilder = request.getParameter("wantBuilder");
        Bom bom = bomBuilder.getBom(carport.getId());
        request.setAttribute("bom", bom);
        request.setAttribute("carport", carport);
        request.setAttribute("carportFacade", carportFacade);
        request.setAttribute("userFacade", userFacade);
        request.setAttribute("wantBuilder", wantBuilder);
        int userId = (int) session.getAttribute("userId");
        String role = user.getRole();
        ArrayList<Query> queries = new ArrayList<>();
        Query query = new Query(userId, carport.getId(), "Created", "Robotmachine", wantBuilder); // add wantbuilder


        if (user.getRole().equals("customer")) {
            queryFacade.createQuery(userId, carport.getId(), "Created", "Robotmachine", wantBuilder);
            queries = queryFacade.getQueries(userId);
            request.setAttribute("queries", queries);
        }

        if (user.getRole().equals("employee")) {
            queries = queryFacade.getAllQueries();
            request.setAttribute("queries", queries);
        }
        return pageToShow;
    }
}