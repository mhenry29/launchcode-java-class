/**
 * Created by melissa on 5/13/15.
 */
public class RunFightStrategy implements FightStrategy {

    @Override
    public void attack() {
        System.out.println("\tI don't attack");

    }

    @Override
    public void move() {
        System.out.println("\tRunning Away!");

    }
}
