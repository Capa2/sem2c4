package web.commands;

import business.entities.Carport;
import business.services.BomBuilder;
import business.services.CarportFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexCommand extends CommandUnprotectedPage {
    final private CarportFacade carportFacade;
    final private BomBuilder bomBuilder;

    public IndexCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        bomBuilder = new BomBuilder(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

        request.setAttribute(("models"), carportFacade.getModels());
        request.setAttribute("bomBuilder", bomBuilder);

        return pageToShow;
    }
}