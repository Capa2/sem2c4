package web.commands;

import business.entities.Carport;
import business.entities.Query;
import business.entities.User;
import business.persistence.Database;
import business.services.CarportFacade;
import business.services.QueryFacade;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModelCommand extends CommandUnprotectedPage
{
    private CarportFacade carportFacade;

    public ModelCommand(String pageToShow)
    {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String id = request.getParameter("id");
        String name = request.getParameter("name");

//            Query query = QueryFacade.createQuery(get_userID, user_name, carport_name);
            HttpSession session = request.getSession();

//            session.setAttribute("carport_name", name);
//            session.setAttribute("carport_id", carport_id);

        return pageToShow;
        }
    }