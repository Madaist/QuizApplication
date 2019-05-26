package services;

import dao.DatabaseConnection;
import domain.Category;
import domain.Question;
import domain.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Scanner;


public class UserService {

    public static String createAccount(User user){

        ArrayList<String> usernames = DatabaseConnection.getAllUsernames();

        if(usernames.contains(user.getUserName())) {
            return "Username already exists. Please insert another username.";
        }
        if(user.getPassword() == null || user.getPassword().length() < 4) {
            return "Password has to contain at least 4 characters. Please insert another password.";
        }

        DatabaseConnection.insertUser(user);
        return "Account has been successfully created.";
        //session.setAttribute("userId", user.getID());
    }

    public static String login(String userLogin, String passwordLogin) {

        ArrayList<String> usernames = DatabaseConnection.getAllUsernames();
        if(!usernames.contains(userLogin)) {
            return "Username is not correct.\nPlease insert your username again.";
        }

        String password = DatabaseConnection.getPassword(userLogin);
        if (!passwordLogin.equals(password))
            return "Password is not correct.\nPlease insert your password again.";

        return "Login successful";
    }


    public static int calculateScore(ArrayList<Character> userAnswers,
                                     ArrayList<Character> rightAnswers) {
        /*ArrayList<Question> questions = DatabaseConnection.getQuestions(quizId);
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
            */
        int score = 0;
        for(int i = 0; i < rightAnswers.size(); i++)
        {
            if(rightAnswers.get(i).equals(userAnswers.get(i)))
                score += (100 / rightAnswers.size());
        }
        return score;
    }


    public static ArrayList<Character> rightAnswers(int quizId){
        ArrayList<Question> questions = DatabaseConnection.getQuestions(quizId);
        ArrayList<Character> rightAnswers = new ArrayList<>();
        for(int i = 0; i < questions.size(); i++) {
            int rightAnswerPosition = questions.get(i).getAnswers().size() -1;
            rightAnswers.add(questions.get(i).getAnswers().get(rightAnswerPosition).charAt(0));
        }
        return  rightAnswers;
    }

    public static String showRightAnswers(ArrayList<Character> userAnswers,
                                          ArrayList<Character> rightAnswers,
                                          int quizId){
        ArrayList<Question> questions = DatabaseConnection.getQuestions(quizId);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < userAnswers.size(); i++)
        {
            if(userAnswers.get(i) != rightAnswers.get(i)){
                stringBuilder.append("Question: " + questions.get(i).getContent() + "\nYour answer was: ");
                int position1 = poz(userAnswers.get(i));
                if(position1 != -1)
                    stringBuilder.append(questions.get(i).getAnswers().get(position1) + "\n");
                else stringBuilder.append("You did not choose a valid answer\n");
                stringBuilder.append("The right answer was: ");
                int position2 = poz(rightAnswers.get(i));
                stringBuilder.append(questions.get(i).getAnswers().get(position2) + "\n\n");

            }
        }
        return  stringBuilder.toString();

    }


    public static int poz(char letter){
       switch(letter){
           case 'a': return 0;
           case 'b': return 1;
           case 'c': return 2;
           case 'd': return 3;
           default: return -1;
        }
    }



/*
    public static void takeQuiz(HttpSession session) {

        int userId = (Integer)session.getAttribute("userId");
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
                DatabaseConnection.insertScore(userScore, userId, quizId);

                break;
            }
            case 2: {
                ArrayList<Category> categories = DatabaseConnection.selectCategories();
                for(Category category : categories)
                    System.out.println(category);

                System.out.println("Insert category id: ");
                int categoryId = sc.nextInt();
                ArrayList<Integer> ids = DatabaseConnection.getQuizIdByCategory(categoryId);
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
                DatabaseConnection.insertScore(userScore, userId, quizId);
                break;
            }
        }
    } */

}
