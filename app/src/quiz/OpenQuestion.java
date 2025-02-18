package quiz;

public class OpenQuestion extends Question {
    public OpenQuestion(String question, String answer, int score) {

    }

    public OpenQuestion ( String question , String answer ) {
        new OpenQuestion(question,answer,5);
    }

}
