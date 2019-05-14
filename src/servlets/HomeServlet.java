package servlets;

import domain.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = null;
        String loginStatus = UserService.login(username, password, session );

        if(loginStatus.equals("Login successful"))
            resp.sendRedirect("/quizzes");
        else{
            PrintWriter out = resp.getWriter();
            out.println(loginStatus);
            out.close();
        }
    }
}
