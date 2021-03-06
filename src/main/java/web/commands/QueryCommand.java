package web.commands;

import business.entities.*;
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
    final private ResponseFacade responseFacade;
    final private SvgBuilder svgBuilder;
    private Carport carport;


    public QueryCommand(String pageToShow) {
        super(pageToShow);
        carportFacade = new CarportFacade(database);
        queryFacade = new QueryFacade(database);
        userFacade = new UserFacade(database);
        bomBuilder = new BomBuilder(database);
        svgBuilder = new SvgBuilder(database);
        quickBuilder = new QuickBuilder();
        responseFacade = new ResponseFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String message = null;
        int wantBuilder = 0;
        int fromQ = 0;

        if (request.getParameter("submitCustom") != null) {
            carport = carportFacade.createGetCarport(quickBuilder.getCarport(request));
        } else {
            int id = Integer.parseInt(request.getParameter("queriedId"));
            carport = carportFacade.getCarport(id);
        }

        if(request.getParameter("userId") != null){
            int userId = Integer.parseInt(request.getParameter("userId"));
            request.setAttribute("customer", userFacade.getUser(userId));
        }

        if(request.getParameter("wantBuilder") != null)
        {
            wantBuilder = Integer.parseInt(request.getParameter("wantBuilder"));
            request.setAttribute("wantBuilder", wantBuilder);
        }

        if(request.getParameter("fromQ") != null)
        {
            fromQ = Integer.parseInt(request.getParameter("fromQ"));
            request.setAttribute("fromQ", fromQ);
        }
        System.out.println(fromQ);

        Bom bom = bomBuilder.getBom(carport);
        String svgString = svgBuilder.draw(carport, bom);
        request.setAttribute("svg", svgString);

        request.setAttribute("bom", bom);
        request.setAttribute("carport", carport);

        request.setAttribute("carportFacade", carportFacade);
        request.setAttribute("userFacade", userFacade);
        request.setAttribute("queryFacade", queryFacade);
        request.setAttribute("responseFacade", responseFacade);
        request.setAttribute("message", message);

        if(user.getRole().equals("customer") && fromQ == 0) {
            Query query = queryFacade.createQuery(user.getId(), carport.getId(), "created", message, wantBuilder);
            request.setAttribute("query", query);
        }

        return pageToShow;
    }
}