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

}
