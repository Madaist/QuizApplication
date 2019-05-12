package services;

import dao.DatabaseConnection;
import domain.Question;
import domain.User;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    public static void createAccount(){
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Last name: ");
        user.setLastName(sc.next());
        System.out.println("First name:");
        user.setFirstName(sc.next());
        System.out.println("Phone number:");
        user.setPhoneNumber(sc.next());
        System.out.println("Username: ");
        user.setUserName(sc.next());
        System.out.println("Password (at least 4 characters):");
        user.setPassword(sc.next());

        ArrayList<String> usernames = DatabaseConnection.getAllUsernames();
        while (usernames.contains(user.getUserName())) {
            System.out.println("Username already exists. Please insert another username:");
            user.setUserName(sc.next());
        }
        while (user.getPassword() == null || user.getPassword().length() < 4) {
            System.out.println("Password has to contain at least 4 characters. Please insert another password: ");
            user.setPassword(sc.next());
        }

        DatabaseConnection.insertUser(user);
    }

    public static void login(String userLogin, String passwordLogin) {
        Scanner sc = new Scanner(System.in);
       /* System.out.println("Username: ");
        String userLogin = sc.next();
        System.out.println("Password: ");
        String passwordLogin = sc.next(); */


        ArrayList<String> usernames = DatabaseConnection.getAllUsernames();
        while (!usernames.contains(userLogin)) {
            System.out.println("Username is not correct. Please insert your username again.");
            userLogin = sc.next();
        }
        String password = DatabaseConnection.getPassword(userLogin);
        while (!passwordLogin.equals(password)) {
            System.out.println("Password is not correct. Please insert your password again.");
            passwordLogin = sc.next();
        }
    }


    public static int calculateScore(int quizId) {
        ArrayList<Question> questions = DatabaseConnection.getQuestions(quizId);
        ArrayList<Character> userAnswers = new ArrayList<>();
        ArrayList<Character> correctAnswers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i).getContent());
            char letter = 'a';
            int k;
            for (k = 0; k < questions.get(i).getAnswers().size() - 1; k++) {
                System.out.println(letter + " " + questions.get(i).getAnswers().get(k));
                letter++;
            }
            correctAnswers.add(questions.get(i).getAnswers().get(k).charAt(0));
            System.out.println("Your answer is: ");
            char answer = sc.next().charAt(0);
            userAnswers.add(answer);
        }

        int score = 0;
        for(int i = 0; i < correctAnswers.size(); i++)
        {
            if(correctAnswers.get(i).equals(userAnswers.get(i)))
                score += questions.get(i).getScore();
        }

        return score;
    }



    public static void takeQuiz(User user) {

        System.out.println("Find quiz by: 1 - description, 2 - category, 3 - name");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1: {
                System.out.println("Insert description: ");
                String description = sc.next();
                ArrayList<Integer> ids = DatabaseConnection.getQuizIdByDescription(description);
                ArrayList<String> quizNames = new ArrayList<>();
                for (int i = 0; i < ids.size(); i++)
                    quizNames.add(DatabaseConnection.getQuizName(ids.get(i)));
                for (int i = 0; i < quizNames.size(); i++) {
                    System.out.print("Nume: " + quizNames.get(i) + ". ID:  " + ids.get(i) + "\n");
                }
                System.out.println("Insert quiz id: ");
                int quizId = sc.nextInt();
                int userScore = calculateScore(quizId);
                System.out.println(userScore);
                int userId = user.getID();
                DatabaseConnection.insertScore(userScore, userId, quizId);

                break;
            }
            case 2: {
                System.out.println("Insert category: ");
                String category = sc.next();
                ArrayList<Integer> ids = DatabaseConnection.getQuizIdByCategory(category);
                ArrayList<String> quizNames = new ArrayList<>();
                for (int i = 0; i < ids.size(); i++)
                    quizNames.add(DatabaseConnection.getQuizName(ids.get(i)));
                for (int i = 0; i < quizNames.size(); i++) {
                    System.out.print("Nume: " + quizNames.get(i) + ". ID:  " + ids.get(i) + "\n");
                }
                System.out.println("Insert quiz id: ");
                int quizId = sc.nextInt();
                int userScore = calculateScore(quizId);
                System.out.println(userScore);
                int userId = user.getID();
                DatabaseConnection.insertScore(userScore, userId, quizId);
                break;
            }
            case 3: {
                System.out.println("Insert the name: ");
                String name = sc.next();
                int quizId = DatabaseConnection.getQuizIdByName(name);
                String quizName = DatabaseConnection.getQuizName(quizId);
                System.out.print("Nume: " + quizName + ". ID:  " + quizId + "\n");
                int userScore = calculateScore(quizId);
                System.out.println(userScore);
                int userId = user.getID();
                DatabaseConnection.insertScore(userScore, userId, quizId);
                break;
            }
        }
    }

}
