import java.util.Scanner;

/**
 * Created by dshook on 4/30/15.
 *
 * Things to discuss today:
 *
 * Inheritance
 *  structure / design
 *  properties
 *  methods
 *  constructors
 *  accessing properties from base classes
 *  Polymorphism
 *
 * User Input
 *  Scanner
 *  Dialogs
 *
 *  ----------------------------------------
 *
 *  Git: fetching from upstream
 * git remote add upstream https://github.com/dsshook/launchcode-java-class
 *  Creating new modules/psets
 *  Pset 2a, 2b, 2c
 *
 */
public class Animal {

    private String name;
    private String foodSource;

    public Animal(String name, String food) {
        this.name = name;
        this.foodSource = food;
    }

    public void eat() {
        System.out.println("I am eating " + this.foodSource);
    }

    public void sleep() {
        System.out.println("zzzzzzzz");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a number");
        String x = s.next();
        System.out.println("You gave me the number: " + x);
    }

}
