package web.commands;

import business.entities.Carport;
import business.exceptions.UserException;
import business.services.CarportFacade;;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QueryCommand extends CommandProtectedPage {
    private CarportFacade carportFacade;

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
        } catch (UserException e) {
            e.printStackTrace();
        }

//        String email = (String) session.getAttribute("email");
//        User user = (User) session.getAttribute("user");
//        Carport carport = (Carport) session.getAttribute("carport");

//        Address address = (Address) session.getAttribute("address");
//        String email = request.getParameter("email");
//        String userEmail = "AlexanderStubMichelsen@gmail.com";
//        User user = (User) session.getAttribute("user");
//        String name = "Alex";
//        session.setAttribute("name", name);
//        UserFacade userfacade = new UserFacade(database);
//        User user;
//        CarportFacade carportfacade = new CarportFacade(database);
//
//        user

        return pageToShow;
    }
}
