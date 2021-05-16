package web.commands;

import business.entities.Address;
import business.entities.Carport;
import business.entities.User;
import business.services.CarportFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QueryCommand extends CommandProtectedPage {


    public QueryCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

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
