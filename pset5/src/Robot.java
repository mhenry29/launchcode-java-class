/**
 * Created by melissa on 5/13/15.
 */
public class Robot {

    private FightStrategy fightStrategy;
    private int health;
    private int power;
    private int speed;
    private int location;
    private String name;
    private String direction;


    public Robot(String name, int speed, int power, FightStrategy s) {
        this.name = name;
        this.fightStrategy = s;
        this.health = 5;
        this.power = power;
        this.speed = speed;
        this.location = 0;
        this.direction = getDirection();

    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }
    public void setHealth() {
        this.health --;
    }

    public double getPower() {
        return this.power;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getDirection() {
        double x = Math.random();

        if ( x < .50) {
            return "forward";
        } else
            return "backwards";
    }

    public void Attack() {
        fightStrategy.attack();
    }

    public void Move() {
        fightStrategy.move();
    }
    public static void main(String args[]) {

        Robot robot1 = new Robot("Sammy", 5, 6, StrategyFactory.getRunStrategy());
        Robot robot2 = new Robot("Zed", 4, 7, StrategyFactory.getAttackStrategy());

        do {
            String direction1 = robot1.getDirection();
            String direction2 = robot2.getDirection();


            if (direction1.equals("forward") && (direction2.equals("forward"))) {

                if (robot1.getSpeed() > robot2.getSpeed()) {
                    System.out.print(robot1.getName());
                    robot1.Attack();
                } else {
                    System.out.print(robot2.getName());
                    robot2.Attack();
                }
                if (robot1.getPower() > robot2.getPower()) {
                    robot2.setHealth();
                    System.out.println(robot2.getName() + "Health:" + Integer.toString(robot2.getHealth()));
                }
                if (robot1.getPower() < robot2.getPower()) {
                    robot1.setHealth();
                    System.out.println(robot1.getName() + "Health:" + Integer.toString(robot1.getHealth()));

                }
            }

        if (direction1.equals("backwards") && (direction2.equals("forward"))) {

            if (robot1.getSpeed() > robot2.getSpeed()) {
                System.out.print(robot1.getName() + "is getting away!\n");
            } else {
                System.out.print(robot2.getName());
                robot2.Attack();
            }
            if (robot1.getPower() > robot2.getPower()) {
                robot2.setHealth();
                System.out.println(robot2.getName() + "Health:" + Integer.toString(robot2.getHealth()));

            }
            if (robot1.getPower() < robot2.getPower()) {
                robot1.setHealth();
                System.out.println(robot1.getName() + "Health:" + robot1.getHealth());

            }
        }

        if (direction1.equals("backwards") && (direction2.equals("backwards"))) {
            System.out.print("No Battle\n");
        }

    } while (robot1.getHealth() > 0 && robot2.getHealth() > 0);

        if (robot1.getHealth() == 0) {
        System.out.println (robot1.getName() + "dies. Game Over");
    }
    if (robot2.getHealth() == 0) {
        System.out.println (robot2.getName() + "dies. Gave Over");
    }

}}
