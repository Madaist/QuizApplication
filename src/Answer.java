public class Answer {
    private int ID;
    String sentence;

    public Answer(int ID, String sentence) {
        this.ID = ID;
        this.sentence = sentence;
    }

    public Answer(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }


}
