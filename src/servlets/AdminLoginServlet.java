package servlets;

import dao.DatabaseConnection;
import services.AdminService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String loginStatus = AdminService.login(username, password );
        //HttpSession session = req.getSession();
        //session.setAttribute("userId", DatabaseConnection.selectUser(username).getID());

        if(loginStatus.equals("Login successful"))
            resp.sendRedirect("http://localhost:8090/QuizApplication/createQuiz.jsp");
        else{
            req.setAttribute("loginStatus", loginStatus);
            req.getRequestDispatcher("/adminLogin.jsp").forward(req, resp);
        }
    }
}
