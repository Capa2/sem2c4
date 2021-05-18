package web.commands;

import business.entities.Carport;
import business.services.BomBuilder;
import business.services.CarportFacade;
import business.exceptions.UserException;
import business.services.SvgBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModelCommand extends CommandUnprotectedPage {
    final private CarportFacade carportFacade;
    final private BomBuilder bomBuilder;
    final private SvgBuilder svgBuilder;

    public ModelCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        bomBuilder = new BomBuilder(database);
        svgBuilder = new SvgBuilder();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        try {
            int carportId = Integer.parseInt(request.getParameter("model"));
            Carport carport = carportFacade.getCarport(carportId);
            request.setAttribute("carport", carport);
            request.setAttribute("bom", bomBuilder.getBom(carportId));
            request.setAttribute("svg", svgBuilder.draw(carport));
        } catch (UserException e) {
            e.printStackTrace();
        }

        return pageToShow;
    }
}