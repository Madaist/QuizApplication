package servlets;

import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String loginStatus = UserService.login(username, password );

        if(loginStatus.equals("Login successful"))
            resp.sendRedirect("http://localhost:8090/QuizApplication/quizzes.jsp");
        else{
            req.setAttribute("loginStatus", loginStatus);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
