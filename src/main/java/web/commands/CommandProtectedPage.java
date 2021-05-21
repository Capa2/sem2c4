package web.commands;

import business.entities.Carport;
import business.entities.User;
import business.services.CarportFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandProtectedPage extends Command
{
    public String role;
    public String pageToShow;

    public CommandProtectedPage(String pageToShow, String role)
    {
        this.pageToShow = pageToShow;
        this.role = role;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {


        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
