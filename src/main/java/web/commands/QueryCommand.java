package web.commands;

import business.entities.Bom;
import business.entities.Carport;
import business.entities.Query;
import business.entities.User;
import business.exceptions.UserException;
import business.services.BomBuilder;
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
    private BomBuilder bomBuilder;


    public QueryCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
        userFacade = new UserFacade(database);
        bomBuilder = new BomBuilder(database);


    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int carportId = Integer.parseInt(request.getParameter("queriedId"));
        Carport carport = carportFacade.getCarport(carportId);
        Bom bom = bomBuilder.getBom(carportId);
        request.setAttribute("bom", bom);
        System.out.println(carport.getLength());
        request.setAttribute("carport", carport);
        request.setAttribute("carportFacade", carportFacade);
//        request.setAttribute("carport", carport);
        String wantBuilder = "";
        wantBuilder = request.getParameter("wantBuilder");
        request.setAttribute("wantBuilder", wantBuilder);

        // lav en lidt lækkerside på querypage



        // list over queries
        request.setAttribute("userFacade", userFacade);
//        id, roofAngle, width, length, shedWidth, shedLength

        int userId = (int) session.getAttribute("userId");
        String role = (String) session.getAttribute("role");
        ArrayList<Query> queries = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        Query query = new Query(userId, carportId, "Xreated", "Robotmachine", wantBuilder); // add wantbuilder

        try {
            if (role.equals("customer") || role.equals("Kunde")) {
                role = "Kunde";
                queryFacade.createQuery(userId, carport.getId(), "Xreated", "Robotmachine", wantBuilder);
                queries = queryFacade.getQueries(userId);
                request.setAttribute("queries", queries);
                session.getAttribute("user");
            }

            if (role.equals("employee") || role.equals("Sælger")) {
                role = "Sælger";
                queries = queryFacade.getAllQueries();
                request.setAttribute("queries", queries);
            }

            session.setAttribute("role", role);

            return pageToShow;
        } catch(UserException e){
            e.printStackTrace();
        }
        return role;
    }
}