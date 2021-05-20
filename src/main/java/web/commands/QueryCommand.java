package web.commands;

import business.entities.Bom;
import business.entities.Carport;
import business.entities.Query;
import business.entities.User;
import business.exceptions.UserException;
import business.services.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QueryCommand extends CommandUnprotectedPage {
    final private CarportFacade carportFacade;
    final private QueryFacade queryFacade;
    final private UserFacade userFacade;
    final private BomBuilder bomBuilder;
    final private QuickBuilder quickBuilder;
    private SvgBuilder svgBuilder;
    private Carport carport;
    private boolean custom;


    public QueryCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
        userFacade = new UserFacade(database);
        bomBuilder = new BomBuilder(database);
        svgBuilder = new SvgBuilder(database);
        quickBuilder = new QuickBuilder();

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String wantBuilder = request.getParameter("wantBuilder");
        if (request.getParameter("submitCustom") != null) {
            carport = carportFacade.createGetCarport(quickBuilder.getCarport(request));
            custom = true;
        } else {
            int id = Integer.parseInt(request.getParameter("queriedId"));
            carport = carportFacade.getCarport(id);
            custom = false;
        }
        Query query = queryFacade.createQuery(user.getId(),carport.getId(),"created", "message", wantBuilder);
        Bom bom = bomBuilder.getBom(carport.getId());
        String svgString = svgBuilder.draw(carport, bom);
        request.setAttribute("svg", svgString);
        request.setAttribute("query", query);
        request.setAttribute("bom", bom);
        request.setAttribute("carport", carport);
        request.setAttribute("custom", custom);

        request.setAttribute("carportFacade", carportFacade);
        request.setAttribute("userFacade", userFacade);
        request.setAttribute("queryFacade", queryFacade);
        request.setAttribute("wantBuilder", request.getParameter("wantBuilder"));

        return pageToShow;
    }
}