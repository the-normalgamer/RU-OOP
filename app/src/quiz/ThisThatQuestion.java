package quiz;

public class ThisThatQuestion extends MultipleChoiceQuestion{
    ThisThatQuestion (String question, String answer1, String answer2 , int correctAnswer , int score){

    }
    ThisThatQuestion ( String question, String answer1, String answer2 , int correctAnswer ){
        new ThisThatQuestion(question, answer1, answer2, correctAnswer, 5)
    }
}
