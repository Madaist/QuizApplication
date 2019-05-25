package servlets;

import dao.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FindQuizByNameFromCategoriesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String quizName = req.getParameter("quizName");

        ArrayList<String> quizNames = DatabaseConnection.selectQuizNames();
        if (quizNames.contains(quizName))
            req.getRequestDispatcher("/takeQuiz").forward(req, resp);
        else {
            String error = "The name of the quiz is not valid";
            req.setAttribute("error", error);
           req.getRequestDispatcher("/findQuizzesByCategory.jsp").forward(req, resp);
        }
    }
}
