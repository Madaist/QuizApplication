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

public class CreateQuizPart2Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int nrQuestions = (int) session.getAttribute("nrQuestions");
        int nrAnswers = (int) session.getAttribute("nrAnswers");
        int quizId = (int) session.getAttribute("newQuizId");

        for(int i = 0; i < nrQuestions; i++){
            String content = req.getParameter("content");
            int score = Integer.parseInt(req.getParameter("score"));
            ArrayList<String> answers = new ArrayList<>();
            for(int j = 0; j < nrAnswers; j++){
                String answer = req.getParameter("answer");
                answers.add(answer);
            }
            answers.add(req.getParameter("rightAnswer"));

            Question question = new Question(content, score, answers, quizId);
            DatabaseConnection.insertQuestion(question);
        }

        resp.sendRedirect("http://localhost:8090/QuizApplication/quizCreated.jsp");


    }
}
