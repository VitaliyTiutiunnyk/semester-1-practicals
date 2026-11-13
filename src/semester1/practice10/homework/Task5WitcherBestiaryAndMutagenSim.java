package semester1.practice10.homework;

import java.util.random.RandomGenerator;

public class Task5WitcherBestiaryAndMutagenSim {
    public static void main(String[] args){
        Weapon[] arsenal = {
                new RiversOfBlood("Ріки Крові +10", 160),
                new DarkMoonGreatsword("Дворучник Темного Місяця +10", 190),
                new BlasphemousBlade("Богохульний Клинок +10", 180)
        };
        Tarnished tarnished = new Tarnished("VitalityBooster", 1200, arsenal);
        AbstractBoss[] bestiary = {
                new DragonlordPlacidusax("Владика Драконів Пласідусакс", "Стародавній Дракон", 950),
                new BlackKnifeAssassin("Вбивця Чорних Ножів", "Тіньовий Асасин", 750),
                new Malenia("Маленія, Клинок Мікелли", "Напівбогиня Гнилі", 1300),
                new EldenBeast("Звір Елдена", "Втілення Великої Волі", 1500)
        };
        System.out.println("====================================================");
        System.out.println("   БЕСТІАРІЙ МІЖЗЕМ'Я: ПОХІД ЗА КІЛЬЦЕМ ЕЛДЕНА");
        System.out.println("====================================================");
        System.out.println("Герой: " + tarnished);

        int defeatedCount = 0;
        for (AbstractBoss boss : bestiary) {
            if (!tarnished.isAlive()) {
                break;
            }
            System.out.println("\n****************************************************");
            System.out.println("НОВИЙ БОС: " + boss);
            System.out.println("🗣️ " + boss.getName() + ": \"" + boss.getBattleCry() + "\"");
            tarnished.selectBestWeapon(boss);
            System.out.println("****************************************************");
            int round = 1;
            while (boss.isAlive() && tarnished.isAlive()) {
                System.out.println("\n========== РАУНД " + round + " ==========");

                int dealtDamage = tarnished.executeAttack(boss);
                if (tarnished.getCurrentWeapon() instanceof RiversOfBlood rob && rob.isBleedTriggered()) {
                    System.out.println("🩸 КРОВОТЕЧА! Розрив плоті завдає нищівної шкоди!");
                }
                System.out.println("⚔️ " + tarnished.getName() + " атакує зброєю ["
                        + tarnished.getCurrentWeapon().getName() + "] і завдає " + dealtDamage + " шкоди!");
                System.out.println("   Стан боса -> " + boss);
                if (!boss.isAlive()) {
                    System.out.println("🏆 ВЕЛИКОГО ВОРОГА ПОВАЛЕНО: " + boss.getName() + "!");
                    defeatedCount++;
                    break;
                }
                if (boss instanceof RegeneratingBoss reg) {
                    int healed = reg.regenerateHealth();
                    if (healed > 0) {
                        System.out.println("💚 " + boss.getName() + " відновлює " + healed + " HP!");
                    } else {
                        System.out.println("🧊 Регенерація " + boss.getName() + " заблокована Морозним Горщиком!");
                    }
                }
                int bossDmg = boss.calculateBossAttack();
                tarnished.takeDamage(bossDmg);
                System.out.println("💥 " + boss.getName() + " завдає у відповідь " + bossDmg + " шкоди!");
                System.out.println("   " + tarnished);
                int flaskHeal = tarnished.drinkFlask();
                if (flaskHeal > 0) {
                    System.out.println("🧪 Погаслий п'є Флягу Багряних Сліз і відновлює +" + flaskHeal + " HP!");
                }
                round++;
            }
            if (tarnished.isAlive()) {
                tarnished.restAtGrace();
            }
        }
        System.out.println("\n====================================================");
        System.out.println("                 ПІДСУМОК ПОХОДУ");
        System.out.println("====================================================");
        System.out.println("Повалено босів: " + defeatedCount + " з " + bestiary.length);
        System.out.println("Фінальний стан героя: " + tarnished);
        if (tarnished.isAlive() && defeatedCount == bestiary.length) {
            System.out.println("👑 ПЕРЕМОГА! Погаслий зійшов на трон як Владика Елдена!");
        } else {
            System.out.println("💀 ТИ ЗАГИНУВ... Спробуй ще раз біля Благодаті.");
        }

    }
}
interface FlyingBoss{
    boolean isAirborne();
    void knockDownWithGravity();
}
interface RegeneratingBoss{
    int regenerateHealth();
    void blockRegenWithFrostPot();
    boolean isRegenBlocked();
}
interface InvisibleBoss{
    boolean isInvisible();
    void revealWithSentryTorch();
}
abstract class Weapon{
    private final String name;
    private final int baseDamage;
    Weapon(String name, int baseDamage){
        this.baseDamage=baseDamage;
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public abstract int calculateTotalDamage(AbstractBoss target);
}
class RiversOfBlood extends Weapon {
    private boolean bleedTriggered;
    private final RandomGenerator random = RandomGenerator.getDefault();

    RiversOfBlood(String name, int baseDamage) {
        super(name, baseDamage);
    }

    public boolean isBleedTriggered() {
        return bleedTriggered;
    }

    @Override
    public int calculateTotalDamage(AbstractBoss target) {
        bleedTriggered = false;
        if (random.nextInt(100) < 35) { // 35% шанс кровотечения
            bleedTriggered = true;
            return (int) (getBaseDamage() * 1.8) + 80;
        }
        return (int) (getBaseDamage() * 1.2);
    }
    }
    class DarkMoonGreatsword extends Weapon{
        DarkMoonGreatsword(String name, int baseDamage){
            super(name, baseDamage);
        }

        @Override
        public int calculateTotalDamage(AbstractBoss target) {
            if (target instanceof FlyingBoss){
                return getBaseDamage()+100;
            }
            return getBaseDamage();
        }
    }
    class BlasphemousBlade extends Weapon{
        BlasphemousBlade(String name, int baseDamage){
            super(name, baseDamage);
        }

        @Override
        public int calculateTotalDamage(AbstractBoss target) {
            if (target instanceof RegeneratingBoss){
              return   getBaseDamage() + 130;
            }
            return getBaseDamage() + 70;
        }
    }
    class Tarnished{
        private int hp;
        private final int maxHp;
        private final String name;
        private final Weapon[] arsenal;
        private Weapon currentWeapon;
        private int flasks = 3;
        Tarnished(String name, int maxHp, Weapon[] arsenal){
            this.name = name;
            this.maxHp = maxHp;
            this.hp = maxHp;
            this.arsenal = arsenal;
            this.currentWeapon = arsenal[0];
        }
        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public int getMaxHp() {
            return maxHp;
        }

        public Weapon getCurrentWeapon() {
            return currentWeapon;
        }

        public final boolean isAlive() {
            return hp > 0;
        }

        public void takeDamage(int dmg) {
            hp = Math.max(0, hp - dmg);
        }

        public int drinkFlask() {
            if (flasks > 0 && hp < maxHp * 0.45) {
                flasks--;
                int oldHp = hp;
                hp = Math.min(maxHp, hp + 220);
                return hp - oldHp;
            }
            return 0;
        }
        public void restAtGrace() {
            this.hp = Math.min(maxHp, this.hp + 300);
            this.flasks = Math.min(3, this.flasks + 1);
            System.out.println("\n✨ Відпочинок біля Місця Благодаті: відновлено +300 HP та +1 Флягу!");
        }

        public void selectBestWeapon(AbstractBoss target) {
            Weapon best = arsenal[0]; // за замовчуванням Ріки Крові
            for (Weapon w : arsenal) {
                if (target instanceof RegeneratingBoss && w instanceof BlasphemousBlade) {
                    best = w;
                    break;
                }
                if (target instanceof FlyingBoss && w instanceof DarkMoonGreatsword) {
                    best = w;
                }
            }
            this.currentWeapon = best;
            System.out.println("🗡️ Погаслий обирає з арсеналу: " + currentWeapon.getName()
                    + " (база: " + currentWeapon.getBaseDamage() + ")");
        }

        public void prepareForBoss(AbstractBoss target) {
            if (target instanceof InvisibleBoss inv && inv.isInvisible()) {
                System.out.println("🔦 Погаслий дістає Смолоскип Вартового — невидимість розвіяно!");
                inv.revealWithSentryTorch();
            }
            if (target instanceof FlyingBoss fly && fly.isAirborne()) {
                System.out.println("🌌 Погаслий застосовує Попіл Війни: Гравітація — боса збито на землю!");
                fly.knockDownWithGravity();
            }
            if (target instanceof RegeneratingBoss reg && !reg.isRegenBlocked()) {
                System.out.println("❄️ Погаслий кидає Морозний Горщик — регенерацію заблоковано!");
                reg.blockRegenWithFrostPot();
            }
        }

        public final int executeAttack(AbstractBoss target) {
            prepareForBoss(target);
            int hpBefore = target.getHp();
            int dmg = currentWeapon.calculateTotalDamage(target);
            target.receiveDamage(dmg);
            return hpBefore - target.getHp();
        }

        @Override
        public String toString() {
            return "Погаслий " + name + " [HP: " + hp + "/" + maxHp + " | Фляг: " + flasks
                    + " | Зброя: " + currentWeapon.getName() + "]";
        }
    }

abstract class AbstractBoss{
    private final String name;
    private final String bossClass;
    protected int hp;
    protected final int maxHp;
    AbstractBoss(String name, String bossClass, int maxHp){
        this.bossClass=bossClass;
        this.name=name;
        this.maxHp=maxHp;
        this.hp=maxHp;
    }
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }
    public abstract int calculateBossAttack();
    public abstract String getBattleCry();
    public final boolean isAlive(){
        return hp>0;
    }
    public void receiveDamage(int dmg){
        hp = Math.max(0, hp - dmg);
    }
    @Override public String toString(){
        return name + " [" + bossClass + " | HP: " + hp + "/" + maxHp + "]";
    }

}
class DragonlordPlacidusax extends AbstractBoss implements FlyingBoss{
    private boolean airborne = true;
    DragonlordPlacidusax(String name, String bossClass, int maxHp){
        super(name, bossClass, maxHp);
    }
    @Override
    public int calculateBossAttack() {
        return 140;
    }

    @Override
    public String getBattleCry() {
        return "Громові хмари Фарум-Азули спопелять тебе!";
    }

    @Override
    public boolean isAirborne() {
        return airborne;
    }

    @Override
    public void knockDownWithGravity() {
        this.airborne = false;
    }
    @Override
    public void receiveDamage(int dmg) {
        int finalDmg = airborne ? dmg / 2 : dmg;
        super.receiveDamage(finalDmg);
    }
}
class BlackKnifeAssassin extends AbstractBoss implements InvisibleBoss{
    private boolean invisible = true;
    BlackKnifeAssassin(String name, String bossClass, int maxHp){
        super(name, bossClass, maxHp);
    }

    @Override
    public int calculateBossAttack() {
        return 115;
    }

    @Override
    public String getBattleCry() {
        return "Руна Смерті наздожене тебе з тіні...";
    }
    @Override
    public boolean isInvisible() {
        return invisible;
    }

    @Override
    public void revealWithSentryTorch() {
        this.invisible = false;
    }
    @Override
    public void receiveDamage(int dmg) {
        int finalDmg;
        if (invisible) {
            finalDmg = (int) (dmg * 0.2);
        } else {
            finalDmg = dmg;
        }
        super.receiveDamage(finalDmg);
    }
}
class Malenia extends AbstractBoss implements FlyingBoss, RegeneratingBoss{
    Malenia(String name, String bossClass, int maxHp){
        super(name, bossClass, maxHp);
    }
    private boolean airborne = true;
    private boolean regenBlocked = false;
    private final RandomGenerator random = RandomGenerator.getDefault();

    @Override
    public boolean isAirborne() {
        return airborne;
    }

    @Override
    public void knockDownWithGravity() {
        this.airborne=false;
    }
    @Override
    public int calculateBossAttack() {
        if (random.nextInt(100) < 25) {
            System.out.println("🌪️ ВОДЯНИЙ ТАНЕЦЬ! Маленія проводить нищівну серію ударів!");
            return 340;
        }
        return 180;
    }
    @Override
    public String getBattleCry() {
        return "Я — Маленія, Клинок Мікелли. І я ніколи не знала поразки.";
    }
    @Override
    public boolean isRegenBlocked() {
        return regenBlocked;
    }

    @Override
    public int regenerateHealth() {
        if (regenBlocked) {
            return 0;
        }
        int heal = 120;
        this.hp = Math.min(maxHp, this.hp + heal);
        return heal;
    }

    @Override
    public void blockRegenWithFrostPot() {
        this.regenBlocked = true;
    }

    @Override
    public void receiveDamage(int dmg) {
        int finalDmg = airborne ? dmg / 2 : dmg;
        super.receiveDamage(finalDmg);
    }

}
final class EldenBeast extends AbstractBoss implements FlyingBoss{
    private boolean airborne = true;
    private final RandomGenerator random = RandomGenerator.getDefault();
    EldenBeast(String name, String bossClass, int maxHp){
        super(name, bossClass, maxHp);
    }
    @Override
    public int calculateBossAttack() {
        if (random.nextInt(100) < 30) {
            System.out.println("✨ КІЛЬЦЕ ЕЛДЕНА! Звір атакує сліпучим променем Великої Волі!");
            return 380;
        }
        return 220;
    }

    @Override
    public String getBattleCry() {
        return "Воля Великого Дерева Ерд непохитна!";
    }

    @Override
    public boolean isAirborne() {
        return airborne;
    }

    @Override
    public void knockDownWithGravity() {
        this.airborne = false;
    }
    @Override
    public void receiveDamage(int dmg) {
        int finalDmg = airborne ? dmg / 2 : dmg;
        super.receiveDamage(finalDmg);
    }
}