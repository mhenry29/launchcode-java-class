/**
 * Created by melissa on 5/13/15.
 */
public class RunFightStrategy implements FightStrategy {


    @Override
    public void fight(Robot decider) {
        System.out.println(decider.getName() + " is challenger and is running away!");
    }
}
