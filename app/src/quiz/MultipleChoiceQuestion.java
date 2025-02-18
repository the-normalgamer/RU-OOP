package quiz;

public class MultipleChoiceQuestion extends Question{
    public MultipleChoiceQuestion ( String question, String [] answers, int correctAnswer, int score){

    }
    public MultipleChoiceQuestion ( String question, String [] answers, int correctAnswer){
        new MultipleChoiceQuestion(question, answers, correctAnswer, 3);
    }
}
