package web.commands;

import business.entities.Carport;
import business.entities.Query;
import business.entities.User;
import business.exceptions.UserException;
import business.services.*;
;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class QueriesCommand extends CommandUnprotectedPage {
    private CarportFacade carportFacade;
    private QueryFacade queryFacade;
    private UserFacade userFacade;
    private BomBuilder bomBuilder;
    private SvgBuilder svgBuilder;

    public QueriesCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
        userFacade = new UserFacade(database);
        bomBuilder = new BomBuilder(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        request.setAttribute("userFacade", userFacade);
        request.setAttribute("bomBuilder", bomBuilder);
        int userId = (int) session.getAttribute("userId");
        String role = (String) session.getAttribute("role");
        ArrayList<Query> queries;

        try {
            if (role.equals("customer") || role.equals("Kunde")) {
                role = "Kunde";
                queries = queryFacade.getQueries(userId);
                request.setAttribute("queries", queries);
            }

            if (role.equals("employee") || role.equals("Sælger")) {
                role = "Sælger";
                queries = queryFacade.getAllQueries();
                request.setAttribute("queries", queries);
            }
            session.setAttribute("role", role);



        } catch (UserException e) {
            e.printStackTrace();
        }
        return pageToShow;
    }
}