import org.junit.Test;


import junit.framework.TestCase;
/**
 * JUnit tests for Student and Course
 * @author dshook
 *
 */
public class StudentAndCourseTest extends TestCase {
	@Test
	public void testStudentInit() {
		Student s = new Student("Doug", "Shook", 111111);
		assertEquals("Doug Shook", s.getName());
		assertEquals(111111, s.getStudentID());
		//No credits, no GPA
		assertEquals(0.0, s.getGPA(), .001);
		assertEquals(0.0, s.getCredits(), .01);

        //Generate some random students, and test
		for (int i = 0; i < 20; ++i) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			int c = (int)(Math.random() * 5000);
			Student s3 = new Student("" + a, "" + b, c);
			assertEquals(a + " " + b, s3.getName());
			assertEquals(0.0, s3.getGPA());
			assertEquals(0.0, s3.getCredits());
		}

		assertEquals("Doug Shook 111111", s.toString());
		assertEquals("Freshman", s.getClassStanding());
		assertEquals(0.0, s.computeTuition());
		//s.submitGrade(4,3.0);
		//assertEquals(12.0, qScore);
	}

    @Test
    public void testCourseInit() {

		Course b = new Course("CompSci", "Shook", 3, 30);
		assertEquals("CompSci 3", b.toString());
		assertEquals(true, b.addStudent(new Student("mike", "davis", 123456)));
		assertEquals(false, b.addStudent(new Student("mike", "davis", 123456)));
		assertEquals(0.0, b.averageGPA());




	}//More tests should go here

}


