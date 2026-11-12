package semester1.practice10;
import java.util.random.RandomGenerator;
public class Task39 {
    public static void run(){
        AbstractCombatUnit[] units = {
                new BerserkerAssasin("Ассасин", 100),
                new TrollWarlord("Тролль", 100),
                new RoyalPaladin("Паладин", 100)
        };
        int attackerIndex = 0;
        int round = 1;
        while ((units[0].isAlive() && units[1].isAlive())
                || (units[0].isAlive() && units[2].isAlive())
                || (units[1].isAlive() && units[2].isAlive())) {
            AbstractCombatUnit attacker = units[attackerIndex];
            while (!attacker.isAlive()) {
                attackerIndex = (attackerIndex + 1) % units.length;
                attacker = units[attackerIndex];
            }
            int defenderIndex;

            do {
                defenderIndex = RandomGenerator.getDefault().nextInt(units.length);
            } while (defenderIndex == attackerIndex || !units[defenderIndex].isAlive());

            AbstractCombatUnit defender = units[defenderIndex];


            System.out.println("\n========== РАУНД " + round + " ==========");
            System.out.println(attacker.getName() + " атакує " + defender.getName());
            if (attacker instanceof SelfRegenerating reg) {
                int restored = reg.regenerateHp();
                if (restored > 0) {
                    System.out.println(attacker.getName() + " відновив " + restored + " HP");
                }
            }
            int damage = attacker.calculateDamage();
            if (attacker instanceof BerserkerAssasin assassin && assassin.isCriticalHit()) {
                System.out.println("КРИТИЧНИЙ УДАР! Множник: " + assassin.getCritMultiplier());
            }
            if (attacker instanceof TrollWarlord troll && troll.isCriticalHit()) {
                System.out.println("КРИТИЧНИЙ УДАР! Множник: " + troll.getCritMultiplier());
            }
            System.out.println("Базова шкода: " + damage);
            if (defender instanceof ShieldBearer shield) {
                damage = shield.absorbDamage(damage);
                System.out.println("Щит поглинув частину шкоди!");
            }
            defender.hp -= damage;
            System.out.println("Завдано шкоди: " + damage);
            System.out.println(defender.getName() + " HP: " + Math.max(0, defender.hp));
            if (!defender.isAlive()) {
                System.out.println(defender.getName() + " вибуває з бою!");
            }
            attackerIndex = (attackerIndex + 1) % units.length;
            round++;
        }
        System.out.println("\n========== КІНЕЦЬ БОЮ ==========");
        for (AbstractCombatUnit unit : units) {
            if (unit.isAlive()) {
                System.out.println("ПЕРЕМОЖЕЦЬ: " + unit.getName());
                System.out.println("Залишилося HP: " + unit.hp);
            } else {
                System.out.println(unit.getName() + " — переможений");
            }
        }
    }
}
abstract class AbstractCombatUnit{
    private final String name;
    protected int hp;

    public final boolean isAlive() {
        return hp > 0;
    }
    AbstractCombatUnit(String name, int hp){
        this.name=name;
        this.hp=hp;
    }
    public abstract int calculateDamage();

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
}
interface CriticalStriker{
    double getCritMultiplier();
}
interface SelfRegenerating{
    int regenerateHp();
}
interface ShieldBearer{
    int absorbDamage(int incoming);
}
class BerserkerAssasin extends AbstractCombatUnit implements CriticalStriker{
    private final RandomGenerator random = RandomGenerator.getDefault();
    private boolean criticalHit;
    BerserkerAssasin(String name, int hp){
        super(name, hp);
    }
    public boolean isCriticalHit() {
        return criticalHit;
    }
    @Override
    public int calculateDamage() {
        criticalHit=false;
        if (random.nextInt(100) < 25){
            criticalHit = true;
            return (int) (37*getCritMultiplier());
        }
        return 37;
    }

    @Override
    public double getCritMultiplier() {
        return 2;
    }
}
class TrollWarlord extends AbstractCombatUnit implements CriticalStriker, SelfRegenerating{
    private final RandomGenerator random = RandomGenerator.getDefault();
    private boolean criticalHit;
    TrollWarlord(String name, int hp){
        super(name, hp);
    }

    public boolean isCriticalHit() {
        return criticalHit;
    }

    @Override
    public int calculateDamage() {
        criticalHit=false;
        if (random.nextInt(100) < 17){
            criticalHit=true;
            return (int) (30*getCritMultiplier());
        }
        return 30;
    }

    @Override
    public double getCritMultiplier() {
        return 2.1;
    }

    @Override
    public int regenerateHp() {
        int oldHp = hp;
        hp += 10;
        if (hp > 100) {
            hp = 100;
        }
        return hp - oldHp;
    }
}
class RoyalPaladin extends AbstractCombatUnit implements SelfRegenerating, ShieldBearer{
    RoyalPaladin(String name, int hp){
        super(name, hp);
    }
    @Override
    public int calculateDamage() {
        return 20;
    }

    @Override
    public int regenerateHp() {
        int oldHp=hp;
        hp+=10;
        if (hp>100) hp=100;
        return hp-oldHp;
    }

    @Override
    public int absorbDamage(int incoming) {
        return (int) (incoming - incoming * 0.2);
    }
}


