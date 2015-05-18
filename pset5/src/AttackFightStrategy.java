/**
 * Created by melissa on 5/13/15.
 */
public class AttackFightStrategy implements FightStrategy {


    @Override
    public void fight(Robot decider) {
        System.out.println(decider.getName() + " is challenger...Arrrggh! Attack!");

    }
}
