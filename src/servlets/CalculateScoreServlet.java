package servlets;

import dao.DatabaseConnection;
import domain.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CalculateScoreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int userId = (Integer)session.getAttribute("userId");
        int quizId = (Integer)session.getAttribute("quizId");

        ArrayList<Character> userAnswers = new ArrayList<>();
       for(int i = 0; i < 10; i++)
           userAnswers.add(req.getParameter(("answerQ" + (i+1))).charAt(0));
        ArrayList<Character> rightAnswers = UserService.rightAnswers(quizId);

        int score = UserService.calculateScore(userAnswers, rightAnswers);
        DatabaseConnection.insertScore(score, userId, quizId);

        String showRightAnswers = UserService.showRightAnswers(userAnswers, rightAnswers, quizId);

        req.setAttribute("score", score);
        req.setAttribute("showRightAnswers", showRightAnswers);
        req.getRequestDispatcher("/calculateScore.jsp").forward(req, resp);

    }
}
