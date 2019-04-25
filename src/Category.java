import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<Quiz> quizzes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
