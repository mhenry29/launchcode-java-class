/**
 * Created by melissa on 5/14/15.
 */
public class StrategyFactory {


    public static FightStrategy getAttackStrategy() {
        return new AttackFightStrategy();
    }

    public static FightStrategy getRunStrategy() {
        return new RunFightStrategy();
    }

    }
