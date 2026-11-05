package semester1.practice09.homework;

public class Task5CyberpunkRipperdocSim {
    public static void main(String[] args) {
        CyberMercenary david = new CyberMercenary("Ві", 120, 1000);
        david.installImplant(new SandevistanOs("SandevistanOs", "Нейро-ОС", 35));
        david.installImplant(new MantisBlades("MantisBlades", "Руки", 25));
        david.installImplant(new SubdermalTitaniumArmor("SubdermalTitaniumArmor", "Шкіра", 20));
        SandevistanOs secondSandevistan =
                new SandevistanOs("Sandevistan 2", "Нейро-ОС", 35);
        david.reduceHumanity(81);
        david.injectImmunoblockers(50);
        david.showDossier();
        System.out.println("\n⚠️ УВАГА! ВИЯВЛЕНО ЦІЛЬ: ADAM SMASHER");
        System.out.println("⚔️ БОЙОВИЙ ПРОТОКОЛ АКТИВОВАНО!");
        int rounds = 0;
        int initialHp = david.getHp();
        int enemyMaxHp = 1200;
        int smasherHp = enemyMaxHp;
        for (int round = 1; round <= 4; round++) {
            if (smasherHp <= 0 || david.getHp() <= 0) {
                break;
            }
            rounds++;
            System.out.println("\nРаунд " + round);
            System.out.println("Активні імпланти:");
            david.activateImplants();
            int attack = david.getTotalAttack();
            smasherHp -= attack;
            if (smasherHp < 0) {
                smasherHp = 0;
            }
            david.takeDamage(100);
            david.processCyberpsychosisTurn();
            System.out.println("Атака Дэвида: " + attack);
            System.out.println("HP Адама Смешера: " + smasherHp);
            System.out.println("HP Дэвида: " + david.getHp());
            david.showStatus();
        }
        david.showBattleReport(
                "Adam Smasher",
                smasherHp,
                rounds,
                initialHp
        );
        System.out.println("\n=== КІНЕЦЬ БОЮ ===");
    }
}
class BioMonitor{
    private int hp;
    private final int  maxHp;
    private int humanity=100;
    private boolean cyberpsychosis=false;
    BioMonitor(int hp, int maxHp){
        this.hp=hp;
        this.maxHp=maxHp;
    }
    public int getHp() {
        return hp;
    }
    public boolean isCyberpsychosis() {
        return cyberpsychosis;
    }

    public int getHumanity() {
        return humanity;
    }
    public void reduceHumanity(int cost){
        humanity-=cost;
        if (humanity<0){
            humanity=0;
        } if (humanity<20){
            cyberpsychosis = true;
        }
    }
    public void injectImmunoblockers(int restoreAmount){
        humanity+=restoreAmount;
        if (humanity>=20){
            cyberpsychosis=false;
        }
    }
    public int applyDamage(int rawDamage, int totalArmor){
       int damage = Math.max(5, rawDamage - totalArmor);
       hp-=damage;
       if (hp<0){
           hp=0;
       }
       return hp;
    }
    @Override
    public String toString() {
        String hpBar = "";
        String humanityBar = "";
        for (int i = 0; i < 10; i++) {
            if (i < hp * 10 / maxHp) {
                hpBar += "█";
            } else {
                hpBar += "░";
            }
            if (i < humanity / 10) {
                humanityBar += "█";
            } else {
                humanityBar += "░";
            }
        }
        return "HP [" + hpBar + "] " + hp + "/" + maxHp +
                " | Людяність [" + humanityBar + "] " + humanity + "/100" +
                (cyberpsychosis ? " [КІБЕРПСИХОЗ]" : " [Стабільний]");
    }
}
abstract class  AbstractCyberImplant{
    private final String name;
    private final String slot;
    //"Нейро-ОС", "Руки", "Підшкірна броня", "Оптика"
    private final int humanityCost;
    AbstractCyberImplant(String name, String slot, int humanityCost){
        this.name=name;
        this.slot=slot;
        this.humanityCost=humanityCost;
    }
    public String getSlot() {
        return slot;
    }

    public int getHumanityCost() {
        return humanityCost;
    }
    public abstract int getAttackBonus();
    public abstract int getArmorBonus();
    public abstract String activateSpecialAbility();

        @Override
        public String toString() {
            return "Імплант: " + name +
                    " | Слот: " + slot +
                    " | Бонус атаки: +" + getAttackBonus() +
                    " | Бонус броні: +" + getArmorBonus() +
                    " | Вартість людяності: -" + humanityCost;

    }
}
class MantisBlades extends AbstractCyberImplant{
    MantisBlades(String name, String slot, int humanityCost){
        super(name, slot, humanityCost);
    }
    @Override
    public int getAttackBonus() {
        return 110;
    }
    @Override
    public int getArmorBonus() {
        return 5;
    }
    @Override
    public String activateSpecialAbility() {
        return "🔥 Вихор розпечених клинків Богомола розтинає броню ворога!";
    }
}
class SubdermalTitaniumArmor extends AbstractCyberImplant{
    SubdermalTitaniumArmor(String name, String slot, int humanityCost){
        super(name, slot, humanityCost);
    }
    @Override
    public int getAttackBonus() {
        return 10;
    }
    @Override
    public int getArmorBonus() {
        return 65;
    }
    @Override
    public String activateSpecialAbility() {
        return "🛡️ Нано-пластини поглинають кінетичний удар!";
    }

}
class SandevistanOs extends AbstractCyberImplant{
    SandevistanOs(String name, String slot, int humanityCost){
        super(name, slot, humanityCost);
    }
    @Override
    public int getAttackBonus() {
        return 90;
    }
    @Override
    public int getArmorBonus() {
        return 20;
    }
    @Override
    public String activateSpecialAbility() {
        return "⚡ САНДЕВІСТАН АКТИВОВАНО: Час сповільнено на 85%! Вороги завмерли на місці!";
    }
}
class CyberMercenary{
    private final String nickname;
    private final int baseAttack;
    private final BioMonitor bioMonitor;
    private final AbstractCyberImplant[] implants;
    private int implantCount;
    CyberMercenary(String nickname, int baseAttack, int hp) {
        this.nickname = nickname;
        this.baseAttack = baseAttack;
        this.bioMonitor = new BioMonitor(hp, hp);
        this.implants = new AbstractCyberImplant[4];
        this.implantCount = 0;
    }
    public boolean installImplant(AbstractCyberImplant implant){
        if (implant == null || implantCount >= implants.length) {
            return false;
        }
        for (int i=0; i<implantCount; i++){
            if (implants[i].getSlot().equals(implant.getSlot())){
                return false;
            }

        }
        implants[implantCount] = implant;
        implantCount++;
        bioMonitor.reduceHumanity(implant.getHumanityCost());
        return true;
    }
    public int getTotalAttack(){
        int total=baseAttack;
        for (int i=0; i<implantCount; i++){
            total+=implants[i].getAttackBonus();
        }
        if (bioMonitor.isCyberpsychosis()) {
            total = (int)(total * 1.5);
        }
        return total;
    }
    public int getTotalArmor(){
        int total=0;
        for (int i=0; i<implantCount; i++){
            total+=implants[i].getArmorBonus();
        }
        return total;
    }
    public void processCyberpsychosisTurn() {
        if (bioMonitor.isCyberpsychosis()) {
            bioMonitor.applyDamage(20, 0);
        }

    }
    public void activateImplants() {
        for (int i = 0; i < implantCount; i++) {
            System.out.println(implants[i].activateSpecialAbility());
        }
    }
    public void reduceHumanity(int amount) {
        bioMonitor.reduceHumanity(amount);
    }

    public void injectImmunoblockers(int amount) {
        bioMonitor.injectImmunoblockers(amount);
    }

    public void showStatus() {
        System.out.println(bioMonitor);
    }
    public int getHp() {
        return bioMonitor.getHp();
    }

    public void takeDamage(int damage) {
        bioMonitor.applyDamage(damage, getTotalArmor());
    }
        @Override
        public String toString() {
            String result = "CyberMercenary: " + nickname +
                    "\nАтака: " + getTotalAttack() +
                    "\nБроня: " + getTotalArmor() +
                    "\nBioMonitor: " + bioMonitor +
                    "\nВстановлені імпланти:\n";

            for (int i = 0; i < implantCount; i++) {
                result += (i + 1) + ". " + implants[i] + "\n";
            }
            return result;
    }
    public void showDossier() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║              NCPD // DATABASE                    ║");
        System.out.println("║             ДОСЬЄ КІБЕРНАЙМАНЦЯ                  ║");
        System.out.println("╠══════════════════════════════════════════════════╣");

        System.out.println("║ ПОЗИВНИЙ: " + nickname);
        System.out.println("║ СТАТУС: " +
                (bioMonitor.isCyberpsychosis() ? "КІБЕРПСИХОЗ" : "СТАБІЛЬНИЙ"));

        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║               БІОЛОГІЧНІ ДАНІ                    ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ " + bioMonitor);

        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║               БОЙОВІ ПОКАЗНИКИ                   ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ Базова атака:    " + baseAttack);
        System.out.println("║ Загальна атака:  " + getTotalAttack());
        System.out.println("║ Загальна броня:  " + getTotalArmor());

        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║               КІБЕРІМПЛАНТИ                      ║");
        System.out.println("╠══════════════════════════════════════════════════╣");

        for (int i = 0; i < implantCount; i++) {
            System.out.println("║ [" + (i + 1) + "] " + implants[i].getClass().getSimpleName());
            System.out.println("║     Слот: " + implants[i].getSlot());
            System.out.println("║     Атака: +" + implants[i].getAttackBonus()
                    + " | Броня: +" + implants[i].getArmorBonus());
            System.out.println("║     Вартість людяності: -" + implants[i].getHumanityCost());
            System.out.println("║");
        }

        System.out.println("║ Всього імплантів: " + implantCount);
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║          ARASAKA // CLASSIFIED INFORMATION       ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    public void showBattleReport(String enemyName, int enemyMaxHp,
                                 int rounds, int initialHp) {

        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║             БОЙОВИЙ ЗВІТ                  ║");
        System.out.println("╠══════════════════════════════════════════╣");

        System.out.println("║ Боєць: " + nickname);
        System.out.println("║ Противник: " + enemyName);

        if (getHp() > 0 && enemyMaxHp == 0) {
            System.out.println("║ Результат: ПЕРЕМОГА");
        } else {
            System.out.println("║ Результат: ПОРАЗКА");
        }

        System.out.println("║ Раундів проведено: " + rounds);
        System.out.println("║ HP противника: " + enemyMaxHp);
        System.out.println("║ HP Дэвида: " + getHp() + "/" + initialHp);
        System.out.println("║ Отримано шкоди: " + (initialHp - getHp()));

        System.out.println("║ Атака: " + getTotalAttack());
        System.out.println("║ Броня: " + getTotalArmor());

        System.out.println("║ Стан: " +
                (bioMonitor.isCyberpsychosis() ? "КІБЕРПСИХОЗ" : "СТАБІЛЬНИЙ"));

        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║       ЗВІТ СФОРМОВАНО СИСТЕМОЮ            ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}