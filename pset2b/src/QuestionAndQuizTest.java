import org.junit.Test;
import junit.framework.TestCase;

/**
 * Created by melissa on 5/5/15.
 */
public class QuestionAndQuizTest extends TestCase {

        @Test
        public void testQuestionInit() {
            Question q = new Question("What is your name", "Melissa");
            assertEquals("What is your name", q.getQuestionText());
        }


        @Test
        public void testMultiChoice() {
            // while making the quiz (Quiz class, main method)
            String[] choices = {"Melissa", "Jesse"};
            MultChoice mc = new MultChoice("What is my name?", choices, 1);
            assertEquals(true, mc.checkAnswer(choices[1]));

        }

        @Test
        public void testFillIn()  {
            FillIn fi = new FillIn("What is your last name?", "Henry");
            assertEquals(true, fi.checkAnswer("Henry"));
        }

        @Test
        public void NumAnswer()  {
            NumAnswer na = new NumAnswer("What is your age?", 37);
            assertEquals(false, na.checkAnswer("36"));
        }
}