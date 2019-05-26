package servlets;

import dao.DatabaseConnection;
import domain.Quiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;

public class CreateQuizPart1Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String quizName = req.getParameter("name");
        String description = req.getParameter("description");
        int nrQuestions = Integer.parseInt(req.getParameter("numberQ"));
        int nrAnswers = Integer.parseInt(req.getParameter("nrAnswers"));

        ArrayList<String> categories = DatabaseConnection.selectCategoryNames();
        if(!categories.contains(category)){
            DatabaseConnection.insertCategory(category);
        }
        int categoryId = DatabaseConnection.selectCategoryId(category);
        Quiz quiz = new Quiz(nrQuestions, description, categoryId, quizName);
        DatabaseConnection.insertQuiz(quiz);

        HttpSession session = req.getSession();
        session.setAttribute("nrQuestions", nrQuestions);
        session.setAttribute("nrAnswers", nrAnswers);
        session.setAttribute("newQuizId", DatabaseConnection.getQuizIdByName(quizName));

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "    <title>Create quiz</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/createQuiz.css\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"hero-image\">\n" +
                "    <div class=\"hero-text\">\n" +
                "        <h1 style=\"font-size:100px\">Create Quiz</h1>\n" +
                "    </div>\n" +
                "</div><form action =\"createQuiz\" method=\"post\">\n");

        for(int i = 0; i < nrQuestions; i++) {
            out.println("<div>\n" +
                    "    <label for=\"content\">Question content: </label>\n" +
                    "    <input type=\"text\" placeholder=\"Enter the question's content: \" name=\"content\" id=\"content\" required>\n" +
                    "</div>\n" +
                    "\n" +
                    "<div>\n" +
                    "    <label for=\"score\">Question score: </label>\n" +
                    "    <input type=\"number\" placeholder=\"Enter the question's score: \" name=\"score\" id=\"score\" required>\n" +
                    "</div>\n" +
                    "\n");
            for (int j = 0; j < nrAnswers; j++) {
                out.println("<div>\n" +
                        "    <label for=\"answer\">Answer </label>\n" +
                        "    <input type=\"text\" placeholder=\"Enter answer: \" name=\"answer\" id=\"answer\" required>\n" +
                        "</div>");
            }

            out.println("<div>\n" +
                    "    <label for=\"rightAnswer\">Right answer: </label>\n" +
                    "    <input type=\"text\" placeholder=\"a/b/c/d \" name=\"rightAnswer\" id=\"rightAnswer\" required>\n" +
                    "</div>\n" +
                    "\n" +
                    "<br><br>");

        }
        out.println( " <div>\n" +
                        "        <button class = \"btn\" type=\"submit\" name=\"action\">Create quiz</button>\n" +
                        "    </div>\n" +
                        "</form></body>\n" +
                        "</html>");
        out.close();

    }
}
