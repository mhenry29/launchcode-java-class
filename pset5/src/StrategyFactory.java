/**
 * Created by melissa on 5/14/15.
 */
public class StrategyFactory {


    public static FightStrategy getStrategy (Robot robot) {
        if (robot.getPower() > robot.getSpeed()) {
            return new AttackFightStrategy();
        }
        return new RunFightStrategy();
    }

    public static void determineStrategy(Robot robot1, Robot robot2) {

        if (robot1.getSpeed() > robot2.getSpeed() && (robot1.getPower() > robot2.getPower())){

            robot1.setFightStrategy(new AttackFightStrategy());
            robot2.setFightStrategy(new RunFightStrategy());

        }
    }

}
