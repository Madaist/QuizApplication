package services;

import dao.DatabaseConnection;
import domain.Question;
import domain.Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {


    public static String login(String adminLogin, String passwordLogin) {

        ArrayList<String> usernames = DatabaseConnection.getAdminUsernames();
        if(!usernames.contains(adminLogin)) {
            return "Username is not correct.\nPlease insert your username again.";
        }

        String password = DatabaseConnection.getAdminPassword(adminLogin);
        if (!passwordLogin.equals(password))
            return "Password is not correct.\nPlease insert your password again.";

        return "Login successful";
    }

}
