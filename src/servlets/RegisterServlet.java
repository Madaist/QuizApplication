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

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String phoneNumber = req.getParameter("phoneNumber");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(lastName, firstName, phoneNumber, userName, password);
        String registerStatus = UserService.createAccount(user);

        if(registerStatus.equals("Account has been successfully created.")) {
            resp.sendRedirect("http://localhost:8090/QuizApplication/quizzes.jsp");
            HttpSession session = req.getSession();
            session.setAttribute("userId", DatabaseConnection.selectUser(userName).getID());
        }
        else {
            req.setAttribute("registerStatus", registerStatus);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }

    }
}
