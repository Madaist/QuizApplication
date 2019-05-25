package servlets;

import dao.DatabaseConnection;
import domain.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TakeQuizServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String quizName = req.getParameter("quizName");
        int quizId = DatabaseConnection.getQuizIdByName(quizName);
        ArrayList<Question> questions = DatabaseConnection.getQuestions(quizId);
        req.setAttribute("questions", questions);
        req.getRequestDispatcher("/takeQuiz.jsp").forward(req, resp);
    }
}
