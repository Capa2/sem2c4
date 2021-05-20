package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuickBuildCommand extends CommandUnprotectedPage {

    public QuickBuildCommand(String pageToShow) {
        super(pageToShow);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        return pageToShow;
    }
}