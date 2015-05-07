import java.util.Scanner;
import java.lang.String;
/**
 * Created by melissa on 5/6/15.
 */
public class Quiz {

    private Question[] questions;

    public Question[] getQuestions() {
        return questions;
    }
    // Quiz constructor
    public Quiz(Question questions[]) {
        this.questions = questions;
    }

    public static void main(String args[]) {
        String[] choices1 = {"Melissa", "Jesse", "Tonya", "Taylor"};
        String[] choices2 = {"April", "September", "June", "July"};
        Question[] questions = new Question[4];
        questions[0] = new MultChoice("What is my name?", choices1, 1);
        questions[1] = new FillIn("What is your last name?", "Henry");
        questions[2] = new NumAnswer("What is your age?", 37);
        questions[3] = new MultChoice("Which months have 30 days?", choices2, "April, September, June");

        int correct = 0;
        int incorrect = 0;

        // Create new quiz
        Quiz myQuiz = new Quiz(questions);

        // Iterate through quiz questions and answers
        for (int i = 0; i < questions.length; i++) {
            if (myQuiz.getQuestions()[i] != null) {
                questions[i].displayQuestion();
                System.out.print("Answer: ");
                Scanner scan = new Scanner(System.in);
                String text = scan.nextLine();
                if (myQuiz.getQuestions()[i].checkAnswer(text)) {
                    System.out.println("Correct!");
                    correct++;
                }
                else {
                    System.out.println("Sorry, the correct answer is: " + myQuiz.getQuestions()[i].getAnswerText());
                    incorrect++;
                }
            }
        }
        System.out.printf("You have completed the quiz with %d correct answers and %d incorrect!", correct, incorrect);
    }
}
