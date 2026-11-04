package semester1.practice09;

public class Task14 {
    public static void run(){
        WeaponItem weapon=new WeaponItem("'Ріки крові'",145, 100);
        HeroCharacter character=new HeroCharacter(
                "VitalityBooster",
                100,
                null);
        System.out.println(character);
        character.equip(weapon);
        character.attack();
        character.attack();
        System.out.println(character);

    }

}
class WeaponItem {
    private final String name;
    private final int bonusDamage;
    private int durability;

    WeaponItem(String name, int bonusDamage, int durability) {
        this.name = name;
        this.bonusDamage = bonusDamage;
        if (durability > 0 && durability <= 100) {
            this.durability = durability;
        } else {
            this.durability = 100;
        }

    }

    public int useWeapon() {
        if (durability > 0) {
            durability -= 10;
            if (durability < 0) {
                durability = 0;
            }
            return bonusDamage;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Назва зброї: " + name +
                "\nБонусна шкода: " + bonusDamage +
                "\nМіцність: " + durability + "%";
    }
}
class  HeroCharacter{
    private final String nickname;
    private int baseStrength;private WeaponItem equippedWeapon;
    HeroCharacter(String nickname, int baseStrength, WeaponItem equippedWeapon){
        this.nickname=nickname;
       if (baseStrength>0&&baseStrength<=100) this.baseStrength=baseStrength;
       else this.baseStrength=baseStrength;
        this.equippedWeapon=equippedWeapon;
    }
    public void equip(WeaponItem newWeapon){
        this.equippedWeapon=newWeapon;
    }
        public int attack() {
            if (equippedWeapon == null) {
                return baseStrength;
            }
            return baseStrength + equippedWeapon.useWeapon();
        }
    @Override
    public String toString() {
        return "Герой: " + nickname +
                "\nБазова сила: " + baseStrength +
                "\nЗброя: " + (equippedWeapon == null ? "Не екіпірована" : equippedWeapon);
    }
}