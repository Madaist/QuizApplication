package servlets;

import dao.DatabaseConnection;
import domain.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class TakeQuizFromDescriptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int quizId = (int) req.getAttribute("quizId");
        String quizName = DatabaseConnection.getQuizName(quizId);
        HttpSession session = req.getSession();
        session.setAttribute("quizId", quizId);
        ArrayList<Question> questions = DatabaseConnection.getQuestions(quizId);
        req.setAttribute("quizName", quizName);
        req.setAttribute("quizId", quizId);
        req.setAttribute("size",  questions.size());
        for(int i = 0; i < questions.size(); i++ )
            req.setAttribute("question" + (i+1), questions.get(i));
        req.getRequestDispatcher("/takeQuiz.jsp").forward(req, resp);
    }
}
