/**
 * Created by melissa on 5/13/15.
 */
public class AttackFightStrategy implements FightStrategy {


    @Override
    public void attack() {
        System.out.println("Arrrggh! Attack!");
    }

    @Override
    public void move() {
        System.out.println("I'll never run away!");

    }
}
