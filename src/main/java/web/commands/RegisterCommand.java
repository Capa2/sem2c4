package web.commands;


import business.entities.Carport;
import business.entities.User;
import business.persistence.Database;
import business.services.CarportFacade;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;

    public RegisterCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String name = request.getParameter("name");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String street = request.getParameter("street");
        String town = request.getParameter("town");
        int zipCode = Integer.parseInt(request.getParameter("zipCode"));

        if (password1.equals(password2)) {
            User user = userFacade.createUser(email, password1, name, phone, street, town, zipCode);

            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("userId", user.getId());
//            session.setAttribute("town", town);
//            session.setAttribute("zipCode", zipCode);
//            session.setAttribute("street", street);
//            session.setAttribute("town", town);
            return request.getContextPath();
        } else {
            request.setAttribute("error", "the two passwords did not match");
            return "registerpage";
        }
    }

}
//
//private CarportFacade carportFacade;
//
//Carport carport = carportFacade.getModels():
//
//request.setAttribute("carport", carport);
