package quiz;

public class MultipleChoiceQuestion extends Question {
    protected String[] answers;

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
        this.correctAnswer = (correctAnswer >= 0) ? answers[correctAnswer] : "";
        this.evaluation = str -> {
            if (this.correctAnswer.isEmpty()) return score;
            return str.equalsIgnoreCase(this.correctAnswer) ? score : 0;
        };
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
}
