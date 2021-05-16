package web.commands;

import business.entities.Carport;
import business.services.CarportFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModelCommand extends CommandUnprotectedPage {
    private CarportFacade carportFacade;

    public ModelCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
    }

    @Override
<<<<<<< HEAD
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

//        if(session.getAttribute("role") != null)
//        {
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        Carport carport = (Carport) request.getAttribute("carport");

=======
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        int carportId = Integer.parseInt(request.getParameter("model"));
        Carport carport = carportFacade.getCarport(carportId);
        request.setAttribute("carport", carport);
>>>>>>> ed255a93fdca148cc8038fb4035a3aadf5763554
//            Query query = QueryFacade.createQuery(get_userID, user_name, carport_name);


//            session.setAttribute("carport", carport);
//        Carport carport = (Carport) request.getAttribute("carport");
//            session.setAttribute("carport_id", carport_id);

        return pageToShow;
    }
}