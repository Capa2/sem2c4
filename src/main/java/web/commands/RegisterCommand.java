package web.commands;

import business.entities.Address;
import business.entities.Town;
import business.entities.User;
import business.persistence.Database;
import business.services.AddressFacade;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandUnprotectedPage
{
    private UserFacade userFacade;
    private AddressFacade addressFacade;

    public RegisterCommand(String pageToShow)
    {
        super(pageToShow);
        userFacade = new UserFacade(database);
        addressFacade = new AddressFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String name = request.getParameter("name");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String zipCode = request.getParameter("zipCode");


        if (password1.equals(password2))
        {
            User user = userFacade.createUser(email, password1, name, phone);
            Address address = addressFacade.createAddress(street);
//            Town town = addressFacade.createTown(townName);

            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("address", address);
            session.setAttribute("street", address.getStreet());
            session.setAttribute("city", city);
            session.setAttribute("zipCode", zipCode);
            return user.getRole() + "page";
        }
        else
        {
            request.setAttribute("error", "the two passwords did not match");
            return "registerpage";
        }
    }

}
