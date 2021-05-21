package web.commands;

import business.entities.Bom;
import business.entities.Carport;
import business.entities.Material;
import business.services.BomBuilder;
import business.services.CarportFacade;
import business.exceptions.UserException;
import business.services.MaterialFacade;
import business.services.SvgBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class ModelCommand extends CommandUnprotectedPage {
    final private CarportFacade carportFacade;
    final private BomBuilder bomBuilder;
    private SvgBuilder svgBuilder;

    public ModelCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        bomBuilder = new BomBuilder(database);
        svgBuilder = new SvgBuilder(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            int carportId = Integer.parseInt(request.getParameter("model"));
            Carport carport = carportFacade.getCarport(carportId);
            Bom bom = bomBuilder.getBom(carportId);
            for (Material m : bom.getList()) {
                System.out.println(m.getName() + " x" + m.getAmount());
            }
            String svgString = svgBuilder.draw(carport, bom);

            request.setAttribute("carport", carport);
            request.setAttribute("bom", bom);
            request.setAttribute("svg", svgString);
            request.setAttribute("carportId", carportId);
        } catch (UserException e) {
            e.printStackTrace();
        }

        return pageToShow;
    }
}