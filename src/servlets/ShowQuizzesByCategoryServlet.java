package servlets;

import dao.DatabaseConnection;
import services.ShowQuizzesService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowQuizzesByCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int categoryId = Integer.parseInt(req.getParameter("quizCategoryId"));
        ArrayList<Integer> quizzesId = DatabaseConnection.getQuizIdByCategory(categoryId);
        ArrayList<String> quizzesName = new ArrayList<>();
        for(int quizId : quizzesId) {
            String quizName = DatabaseConnection.getQuizName(quizId);
            quizzesName.add(quizName);
        }

        String categoryName = DatabaseConnection.selectCategoryName(categoryId);

        req.setAttribute("quizzesByCategory", ShowQuizzesService.namesArrayToString(quizzesName));
        req.setAttribute("categoryId", categoryId);
        req.setAttribute("categoryName", categoryName);

        req.getRequestDispatcher("/findQuizzesByCategory.jsp").forward(req, resp);


    }
}
