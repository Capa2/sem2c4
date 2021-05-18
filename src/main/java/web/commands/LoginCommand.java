package web.commands;

import business.entities.Address;
import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends CommandUnprotectedPage
{
    private UserFacade userFacade;

    public LoginCommand(String pageToShow)
    {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
        User user = userFacade.login(email, password);
//            Address address = new Address();

        HttpSession session = request.getSession();

        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        session.setAttribute("userId", user.getId());
//        session.setAttribute("email", email);
//        session.setAttribute("name", user.getName());
//        session.setAttribute("phone", user.getPhone());
//        session.setAttribute("street", user.getStreet());
//        session.setAttribute("town", user.getTown());
//        session.setAttribute("zipCode", user.getZipCode());

//        session.setAttribute("address", address);

        String pageToShow = request.getContextPath();

            return REDIRECT_INDICATOR + pageToShow;
        }
        catch (UserException ex)
        {
            request.setAttribute("error", "Wrong username or password!");
            return "loginpage";
        }
    }

}
