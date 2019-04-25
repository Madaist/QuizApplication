import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private ArrayList<Answer> answers;
    private int numberOfQuestions;
    private String description;
    private String category;
    private String ID;
    private String name;

    public void calculateScore(){};

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberQuestions(int numberQuestions) {
        this.numberOfQuestions = numberQuestions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
