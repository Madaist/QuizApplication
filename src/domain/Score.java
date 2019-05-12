package domain;

public class Score {
    private User user;
    private int score;
    private String quizName;

    public Score(User user, int score, String quizName) {
        this.user = user;
        this.score = score;
        this.quizName = quizName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
}
