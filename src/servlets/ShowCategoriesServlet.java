package servlets;

import dao.DatabaseConnection;
import domain.Category;
import services.ShowQuizzesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowCategoriesServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> categories = DatabaseConnection.selectCategories();
        req.setAttribute("categories", ShowQuizzesService.categoryArrayToString(categories));
        req.getRequestDispatcher("/quizzes.jsp").forward(req, resp);


    }
}
