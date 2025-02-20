package quiz;

import java.util.function.Function;

public abstract class Question {
    public static final int DEFAULT_POINTS = 3;
    protected int points;
    protected String question;
    protected String correctAnswer;
    protected Function<String, Integer> evaluation = s -> DEFAULT_POINTS;

    @Override
    public String toString(){
        return ((this.question == null) ? "null" : this.question);
    }

    /**
     * @param answer the entered answer
     * @return whether the submitted answer results in at least 1 point
     */
    public boolean isCorrect(String answer) {
        int score = evaluation.apply(answer);
        return score > 0;
    }

    /**
     * @param answer the input answer
     * @return the number of points rewarded given that answer
     */
    public int getPointReward(String answer) {
        return evaluation.apply(answer);
    }

    public int getScore() {
        return this.points;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
