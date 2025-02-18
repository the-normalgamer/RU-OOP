package quiz;

public class MultipleChoiceQuestion extends Question {
    protected String[] answers;

    public MultipleChoiceQuestion (String question, String [] answers, int correctAnswer, int score){
        this.question = question;
        this.answers = answers;
        this.correctAnswer = answers[correctAnswer];
        this.evaluation = str -> str.equalsIgnoreCase(this.correctAnswer) ? score : 0;
    }

    public MultipleChoiceQuestion (String question, String [] answers, int exampleAnswer){
        new MultipleChoiceQuestion(question, answers, exampleAnswer, DEFAULT_POINTS);
    }
}
