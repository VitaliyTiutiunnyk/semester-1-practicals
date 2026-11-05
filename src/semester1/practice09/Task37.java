package semester1.practice09;

public class Task37 {
    public static void run() {
        RaidParty party = new RaidParty("Radiant", 5);
        party.addMember(new TankWarrior("Axe", 600, 150));
        party.addMember(new TankWarrior("Pudge", 800, 100));
        party.addMember(new ArcaneMage("Invoker", 250, 300, 500));
        System.out.println(party);
        System.out.println("Готовність до рейду: " +
                party.isReadyForRaid(2000));

    }
}
abstract class AbstractHeroUnit {
    private final String name;
    protected int hp;

    AbstractHeroUnit(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public abstract int getCombatPower();

    public abstract String getRole();

    @Override
    public String toString() {
        return "Герой: " + name +
                ", HP: " + hp +
                ", роль: " + getRole() +
                ", бойова сила: " + getCombatPower();
    }
}

class TankWarrior extends AbstractHeroUnit {
    private final int armor;

    TankWarrior(String name, int hp, int armor) {
        super(name, hp);
        this.armor = armor;
    }

    @Override
    public int getCombatPower() {
        return hp + armor * 2;
    }

    @Override
    public String getRole() {
        return "Tank";
    }
}

class ArcaneMage extends AbstractHeroUnit {
    private final int intelligence;
    private final int spellPower;

    ArcaneMage(String name, int hp, int intelligence, int spellPower) {
        super(name, hp);
        this.intelligence = intelligence;
        this.spellPower = spellPower;
    }

    @Override
    public int getCombatPower() {
        return intelligence * 2 + spellPower;
    }

    @Override
    public String getRole() {
        return "Mage";
    }
}

class RaidParty {
    private final String guildName;
    private final AbstractHeroUnit[] members;
    private int memberCount;

    RaidParty(String guildName, int capacity) {
        this.guildName = guildName;
        members = new AbstractHeroUnit[capacity];
        memberCount = 0;
    }

    public boolean addMember(AbstractHeroUnit hero) {
        if (hero == null || memberCount >= members.length) {
            return false;
        }

        members[memberCount] = hero;
        memberCount++;
        return true;
    }

    public int getTotalCombatPower() {
        int total = 0;

        for (int i = 0; i < memberCount; i++) {
            total += members[i].getCombatPower();
        }

        return total;
    }

    public boolean isReadyForRaid(int dungeonDifficulty) {
        boolean hasTank = false;

        for (int i = 0; i < memberCount; i++) {
            if (members[i].getRole().equals("Tank")) {
                hasTank = true;
            }
        }

        return hasTank && getTotalCombatPower() > dungeonDifficulty;
    }

    @Override
    public String toString() {
        return "Гільдія: " + guildName +
                ", кількість героїв: " + memberCount +
                ", загальна бойова сила: " + getTotalCombatPower();
    }
}
