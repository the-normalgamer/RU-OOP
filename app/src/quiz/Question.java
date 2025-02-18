package quiz;

public class Question {
    private int score = 0;
    private String answer;


    @Override
    public String toString(){
        return "";
        //TODO
    }
    public boolean isCorrect(String answer){
        return true;
        //TODO
    }
    public String correctAnswer(){
        return "";
        //TODO
    }
    public int getScore(){
        return this.score;
    }
    public void setScore(int score){
        this.score = score;
    }

}
