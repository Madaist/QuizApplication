package servlets;

import dao.DatabaseConnection;
import domain.Score;
import services.ShowQuizzesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SeeTopServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Score> top = DatabaseConnection.getTop();
        req.setAttribute("top", ShowQuizzesService.scoresArrayToString(top));
        req.getRequestDispatcher("/seeTop.jsp").forward(req, resp);
    }
}
