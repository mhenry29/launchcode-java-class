import java.util.ArrayList;
import java.util.Arrays;



/**
 * Created by melissa on 5/5/15.
 */
public class Question {

    private String questionText;
    private String answerText;

    public Question(String newQuestion, String answer) {
        this.questionText = newQuestion;
        this.answerText = answer;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public String getAnswerText() {
        return this.answerText;
    }

    /* display question */
    public void displayQuestion() {
        System.out.println(this.questionText);
    }

    /* check answer*/
    public boolean checkAnswer(String response) {
        // check to see that there is not a ',' - meaning there is only one answer
        if (response.indexOf(',') == -1) {
            return (response.equalsIgnoreCase(this.answerText));     // will return true of false based on match
        }
        // check to see if there is are multiple answers separated by a string
        else if (response.indexOf(',') != -1) {
            ArrayList<String> guesses = new ArrayList(Arrays.asList(response.split("\\s*,\\s*")));
            ArrayList<String> actualAnswers = new ArrayList(Arrays.asList(this.answerText.split("\\s*,\\s*")));
            if (guesses.containsAll(actualAnswers) && actualAnswers.containsAll(guesses))
                return true;
        }
        return false;
    }
}

