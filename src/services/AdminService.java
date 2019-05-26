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

    public static void createQuiz(){

        Scanner sc = new Scanner(System.in);
        Quiz quiz = new Quiz();
        System.out.println("Insert quiz category: ");
        quiz.setCategoryId(sc.nextInt());
        sc.nextLine();


        System.out.println("Insert quiz description");
        quiz.setDescription(sc.nextLine());

        System.out.println("Insert the number of questions: ");
        quiz.setNumberOfQuestions(sc.nextInt());
        sc.nextLine();
        System.out.println("Insert quiz name: ");
        quiz.setQuizName(sc.nextLine());
        DatabaseConnection.insertQuiz(quiz);



        int quizId = DatabaseConnection.getQuizIdByName(quiz.getQuizName());
        for(int i = 0; i < quiz.getNumberOfQuestions(); i++){
            Question question = new Question();
            System.out.println("Insert question content: ");
            question.setContent(sc.nextLine());
            question.setQuizId(quizId);
            System.out.println("Insert question score: ");
            question.setScore(sc.nextInt());
            sc.nextLine();
            ArrayList<String> answers = new ArrayList<>();
            System.out.println("Insert number of possible answers (<= 4):  ");
            int numberOfAnswers = sc.nextInt();
            sc.nextLine();
            for(int j = 0; j < numberOfAnswers; j++){
                System.out.println("Insert answer: ");
                answers.add(sc.nextLine());
            }
            System.out.println("Insert the correct answer (a/b/c/d): ");
            answers.add(sc.next());
            sc.nextLine();
            question.setAnswers(answers);
            DatabaseConnection.insertQuestion(question);
        }
    }
}
