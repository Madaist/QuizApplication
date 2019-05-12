package domain;

import java.util.ArrayList;

public class Question {

    private int questionID;
    private String content;
    private int score;
    ArrayList<String> answers;
    private int quizId;

    public Question(){}

    public Question(int questionID, String content, int score, ArrayList<String> answers) {
        this.questionID = questionID;
        this.content = content;
        this.score = score;
        this.answers = answers;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
}
