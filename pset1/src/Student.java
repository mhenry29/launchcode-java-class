import java.util.Random;

/**
 * Created by melissa on 4/28/15.
 */
public class Student {

    private String firstName;
    private String lastName;
    private int studentId;
    private double credits;
    private double GPA;
    public double qScore;

    public Student(String firstName, String lastName, int studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.credits = 0;
        this.GPA = 0;
        this.qScore = 0;

    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public int getStudentID() {
        return this.studentId;
    }

    public double getCredits() {
        return this.credits;
    }

    public double getGPA() {
        return this.GPA;
    }

    public String toString() { //returns the students full name and student ID
        return this.firstName + " " + this.lastName + " " + Integer.toString(this.getStudentID());
    }

    // returns the students class standing based on how many credits they have:
    public String getClassStanding() {

        if (this.credits < 30) {
            return "Freshman";
        }
        if (this.credits > 30 && this.credits < 60) {
            return "Sophmore";
        }
        if (this.credits > 60 && this.credits < 90) {
            return "Junior";
        }
        else return "Senior";
    }


    public void submitGrade(int grade, double credits) {
        if (grade > 0 && grade < 4) {
            qScore = qScore + (credits * grade);        // qScore should be global
            this.GPA = qScore / this.getCredits();
        }
    }

    public float computeTuition() {
        int tuition = 0;
        int semesters = (int)(this.getCredits()/15);
            if (semesters >= 1) {
                tuition = semesters * 20000;
            }
            if (semesters < 1)
                System.out.println("Student has not completed a full semester, does not owe any tuition at this time");
            //handle any "leftover" credits
            return tuition;
    }

    public void createLegacy(Student parentM) {

        String legacyName = parentM.getName() + " " + this.getName();
        //System.out.printf("%s", legacyName);
        Random ran = new Random();
        int legacyStudentID = (100000 + ran.nextInt(999999));
        double legacyGPA = (parentM.getGPA() + this.getGPA()/2);
        double legacyCredits = parentM.getCredits() + this.getCredits();
     }

    public static void main(String args[]) {

        Student a = new Student("Melissa", "Henry", 123456);
        System.out.println(a.toString());
        System.out.println(a.getClassStanding());
        a.submitGrade(4, 3.0);
        a.createLegacy(new Student("hello", "dolly", 56788));

    }
}


