/**
 * Created by melissa on 5/13/15.
 */
public class Robot {

    private FightStrategy fightStrategy;
    private int health;
    private int power;
    private int speed;
    private int position;
    private String name;
    private String direction;


    public Robot(String name, int speed, int power) {
        this.name = name;
        this.health = 5;
        this.power = power;
        this.speed = speed;
        this.position = 0;
        this.direction = getDirection();
    }

    public FightStrategy getFightStrategy() {
        return this.fightStrategy;
    }

    public void setFightStrategy(FightStrategy s) {
        this.fightStrategy = s;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }
    public void decHealth(Robot robot) {
        this.health --;
        System.out.println(robot.getName() + " Health:" + Integer.toString(robot.getHealth()));
    }

    public double getPower() {
        // decrease power as robot gets weaker
        if (this.health < 2) {
            this.power--;
        }
        return this.power;
    }

    public int getSpeed() {
        // decrease speed as robot gets weaker
        if (this.health < 2) {
            this.speed--;
        }
        return this.speed;
    }

    public String getDirection() {
        double x = Math.random();

        if ( x < .50) {
            return "forward";
        } else
            return "backwards";
    }

    public int getPosition () {
        if (this.position >= 0 && this.position <= 10) ;
        return this.position;

    }

    public static void doRobotAction(Robot robot1, Robot robot2) {

            StrategyFactory.determineStrategy(robot1, robot2);

            if (robot1.getFightStrategy() == (new AttackFightStrategy())) {
                robot1.getFightStrategy().fight(robot1);
            } else {
                robot2.getFightStrategy().fight(robot2);
            }
            if (robot1.getPower() > robot2.getPower()) {
                robot2.decHealth(robot2);
            }
            if (robot1.getPower() < robot2.getPower()) {
                robot1.decHealth(robot1);

            }
    }


    public static void main(String args[]) {

        Robot robot1 = new Robot("Sammy", 5, 10);
        Robot robot2 = new Robot("Zed", 10, 7);
        robot1.setFightStrategy(StrategyFactory.getStrategy(robot1));
        robot2.setFightStrategy(StrategyFactory.getStrategy(robot2));

        do {

            if (robot1.getDirection().equals("backwards") && (robot2.getDirection().equals("backwards"))) {
                System.out.print("No Battle\n");
            }

            doRobotAction(robot1, robot2);

        } while (robot1.getHealth() > 0 && robot2.getHealth() > 0);

        if (robot1.getHealth() == 0) {
            System.out.println (robot1.getName() + " dies. Game Over");
        }
        if (robot2.getHealth() == 0) {
            System.out.println (robot2.getName() + " dies. Gave Over");
    }

}}
