package servlets;

import dao.DatabaseConnection;
import services.ShowQuizzesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowNamesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> quizNames = DatabaseConnection.selectQuizNames();
        req.setAttribute("names", ShowQuizzesService.namesArrayToString(quizNames));
        req.getRequestDispatcher("/quizzes.jsp").forward(req, resp);
    }
}
