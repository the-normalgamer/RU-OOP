package quiz;

public class MultipleChoiceQuestion extends Question {
    protected String[] answers;
    protected int correctIndex;

    /**
     * Multiple choice question where one question is correct
     * @param question The question to prompt the user with.
     * @param answers List of possible answers.
     * @param correctAnswer Index of {@code answers} which points to the correct answer.
     *                      If negative, every answer is considered correct.
     * @param score The number of points to award when the correct answer is chosen.
     */
    public MultipleChoiceQuestion (String question, String[] answers, int correctAnswer, int score){
        this.question = question;
        this.answers = answers;
        this.correctIndex = correctAnswer;
        this.correctAnswer = (0 <= correctAnswer && correctAnswer < answers.length) ? answers[correctIndex] : "any";
        this.evaluation = str -> {
            if (this.correctIndex < 0) return score;
            return (str.charAt(0) == (char) (this.correctIndex + 97)) ? score : 0;
        };
        this.points = score;
    }

    /**
     * Multiple choice question where one question is correct<br><br>
     * Will set default score of {@value DEFAULT_POINTS}
     * @param question The question to prompt the user with
     * @param answers List of possible answers
     * @param correctAnswer Index of {@code answers} which points to the correct answer
     */
    public MultipleChoiceQuestion (String question, String[] answers, int correctAnswer){
        this(question, answers, correctAnswer, DEFAULT_POINTS);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());

        for (int i = 0; i < this.answers.length; i++) {
            result.append("\n");

            char index = (char) (97 + i); // ASCII value for lowercase A, offset by which nr question
            result.append(index);
            result.append(") ").append(this.answers[i]);
        }

        return result.toString();
    }

    public String getCorrectIndex() {
        return String.valueOf((char) (this.correctIndex + 97));
    }
}
