import java.util.Arrays;

/**
 * Created by melissa on 4/29/15.
 */
public class Course {

    private String name;
    private String instructor;
    private double credits;
    private int numSeats;
    private Student[] roster;

    public Course(String name, String instructor, double credits, int numSeats) {
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
        this.numSeats = numSeats;
        this.roster = new Student[numSeats];
    }

    public int getNumSeats() {
        return numSeats;
    }

    public String toString() {
        return name + " " + Integer.toString((int) this.credits);
    }

    public boolean addStudent(Student student) {
        /*if (Arrays.asList(roster[0].getStudentID()).contains(student.getStudentID())) {
            System.out.println("Student already enrolled");
            return false;
        } else */

        for (int i = 0; i < roster.length; i++) {
            if (roster[i] != null) {
                if (roster[i].getStudentID() == student.getStudentID()) {
                    System.out.println("Student already enrolled");
                    return false;
                }
            }
        }

        this.roster[roster.length - numSeats] = (student);
        this.numSeats--;
        return true;

    }

    public void printRoster() {
        // Print all the array elements
        for (Student student : roster) {
            if (student != null)
                System.out.println(student);
        }
    }

    public double averageGPA() {
        double totalGPA = 0;
        for (Student student : roster) {
            if (student != null)
                totalGPA += student.getGPA();
        }
        return totalGPA / (roster.length - getNumSeats());
    }

    public static void main(String args[]) {
        Course b = new Course("CompSci", "Shook", 3, 30);
        System.out.println(b.toString());
        b.addStudent(new Student("mike", "davis", 123456));
        b.addStudent(new Student("bill", "smith", 123456));
        b.addStudent(new Student("Melissa", "Henry", 123456));
        b.addStudent(new Student("Melissa", "Henry", 123456));
        b.printRoster();
        System.out.println(b.getNumSeats());
        b.averageGPA();
    }
}