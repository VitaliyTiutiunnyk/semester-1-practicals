package semester1.practice10;

public class Task22 {
    public static void run(){
        AbstractMilitaryUnit[] units = {
                new HeavySniper("Снайпер", 120),
                new CombatMedic("Медик", 150),
                new PaladinCaptain("Паладин", 200)
        };
        for (AbstractMilitaryUnit unit : units) {
            System.out.println("\n=== Бойова одиниця ===");
            System.out.println("Назва: " + unit.getUnitName());
            System.out.println("Здоров'я: " + unit.hp);
            System.out.println("Швидкість пересування: " + unit.getMoveSpeed());
            if (unit instanceof RangedAttacker attacker) {
                System.out.println("Дальність атаки: " + attacker.getAttackRange());
                System.out.println("Результат пострілу: " + attacker.fireShot());
            }
            if (unit instanceof FieldHealer healer) {
                System.out.println("Відновлено здоров'я: " + healer.healAlly());
            }
        }
    }
}
abstract class AbstractMilitaryUnit {
    private final String unitName;
    protected int hp;

    AbstractMilitaryUnit(String unitName, int hp) {
        this.unitName = unitName;
        this.hp = hp;
    }

    public String getUnitName() {
        return unitName;
    }

    public abstract int getMoveSpeed();
}

interface RangedAttacker {
    int getAttackRange();
    int fireShot();
}

interface FieldHealer {
    int healAlly();
}

class HeavySniper extends AbstractMilitaryUnit implements RangedAttacker {

    HeavySniper(String unitName, int hp) {
        super(unitName, hp);
    }

    @Override
    public int getMoveSpeed() {
        return 3;
    }

    @Override
    public int getAttackRange() {
        return 15;
    }

    @Override
    public int fireShot() {
        return 80;
    }
}

class CombatMedic extends AbstractMilitaryUnit implements FieldHealer {

    CombatMedic(String unitName, int hp) {
        super(unitName, hp);
    }

    @Override
    public int getMoveSpeed() {
        return 6;
    }

    @Override
    public int healAlly() {
        return 40;
    }
}

class PaladinCaptain extends AbstractMilitaryUnit implements RangedAttacker, FieldHealer {

    PaladinCaptain(String unitName, int hp) {
        super(unitName, hp);
    }

    @Override
    public int getMoveSpeed() {
        return 5;
    }

    @Override
    public int getAttackRange() {
        return 8;
    }

    @Override
    public int fireShot() {
        return 50;
    }

    @Override
    public int healAlly() {
        return 60;
    }
}