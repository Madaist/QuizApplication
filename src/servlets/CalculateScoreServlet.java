package servlets;

import dao.DatabaseConnection;
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
       // int size = (Integer)req.getAttribute("size");
       for(int i = 0; i < 10; i++)
           userAnswers.add(req.getParameter(("answerQ" + (i+1))).charAt(0));
       /* userAnswers.add(req.getParameter("answerQ1").charAt(0));
        userAnswers.add(req.getParameter("answerQ2").charAt(0));
        userAnswers.add(req.getParameter("answerQ3").charAt(0));
        userAnswers.add(req.getParameter("answerQ4").charAt(0));
        userAnswers.add(req.getParameter("answerQ5").charAt(0));
        userAnswers.add(req.getParameter("answerQ6").charAt(0));
        userAnswers.add(req.getParameter("answerQ7").charAt(0));
        userAnswers.add(req.getParameter("answerQ8").charAt(0));
        userAnswers.add(req.getParameter("answerQ9").charAt(0));
        userAnswers.add(req.getParameter("answerQ10").charAt(0));*/
        ArrayList<Character> rightAnswers = UserService.rightAnswers(quizId);

        int score = UserService.calculateScore(userAnswers, rightAnswers);
        DatabaseConnection.insertScore(score, userId, quizId);

        req.setAttribute("score", score);
        req.getRequestDispatcher("/calculateScore.jsp").forward(req, resp);












       /* userAnswers.add(req.getParameter("answerQ1").charAt(0));
        userAnswers.add(req.getParameter("answerQ2").charAt(0));
        userAnswers.add(req.getParameter("answerQ3").charAt(0));
        userAnswers.add(req.getParameter("answerQ4").charAt(0));
        userAnswers.add(req.getParameter("answerQ5").charAt(0));
        userAnswers.add(req.getParameter("answerQ2").charAt(0));
        userAnswers.add(req.getParameter("answerQ2").charAt(0));
        userAnswers.add(req.getParameter("answerQ2").charAt(0));
        userAnswers.add(req.getParameter("answerQ2").charAt(0));
        userAnswers.add(req.getParameter("answerQ2").charAt(0)); */





    }
}
