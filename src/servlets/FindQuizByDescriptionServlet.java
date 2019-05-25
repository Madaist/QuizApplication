package servlets;

import dao.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class FindQuizByDescriptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String description = req.getParameter("quizDescription");
        ArrayList<String> descriptions = DatabaseConnection.selectQuizDescriptions();
        if(descriptions.contains(description))
        {

            req.setAttribute("quizId", DatabaseConnection.getQuizIdByDescription(description));
            req.getRequestDispatcher("/takeQuizFromDescription").forward(req, resp);
        }
        else{
            String error = "The description of the quiz is not valid";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/quizzes.jsp").forward(req, resp);
        }
    }
}
