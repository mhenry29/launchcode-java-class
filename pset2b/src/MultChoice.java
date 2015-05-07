/**
 * Created by melissa on 5/5/15.
 */
public class MultChoice extends Question {

    private String[] choices;
    private String[] indexes;

    public MultChoice(String question, String[] choices, int correctIndex)  {
        super (question, choices[correctIndex]);
        this.choices = choices;
    }

    // Overloading Method for mulitple answers
    public MultChoice(String question, String[] choices, String answers)  {
        super (question, answers);
        this.choices = choices;
    }

    /* will override display () bc we have to display to loop through all the choices in the array */
    public void displayQuestion () {
        super.displayQuestion();
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] != null) {
                System.out.println(choices[i]);
            }
        }
    }

}




