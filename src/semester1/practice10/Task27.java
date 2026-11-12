package semester1.practice10;

public class Task27 {
    public static void run(){
        AbstractWorker[] staff = {
                new FullTimeDeveloper("Олексій", 30000),
                new FopContractor("Андрій", 40000),
                new InternStudent("Максим", 10000)
        };
        auditStaff(staff);
    }
    public static void auditStaff(AbstractWorker[] staff) {
        double totalSalary = 0;
        double totalBonus = 0;
        int insuredCount = 0;
        for (AbstractWorker worker : staff) {
            totalSalary += worker.getSalary();

            if (worker instanceof BonusEligible bonus) {
                totalBonus += bonus.calculateQuarterBonus();
            }
            if (worker instanceof MedicalInsured insured) {
                insured.getInsuranceCoverage();
                insuredCount++;
            }
        }
        System.out.println("Базовий фонд оплати праці: " + totalSalary);
        System.out.println("Сума квартальних премій: " + totalBonus);
        System.out.println("Кількість застрахованих осіб: " + insuredCount);

    }
}
abstract class AbstractWorker {
    private final String name;
    private final double salary;

    AbstractWorker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

interface BonusEligible {
    double calculateQuarterBonus();
}

interface MedicalInsured {
    double getInsuranceCoverage();
}

class FullTimeDeveloper extends AbstractWorker
        implements BonusEligible, MedicalInsured {

    FullTimeDeveloper(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateQuarterBonus() {
        return getSalary() * 0.15;
    }

    @Override
    public double getInsuranceCoverage() {
        return 100000;
    }
}

class FopContractor extends AbstractWorker implements BonusEligible {
    FopContractor(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateQuarterBonus() {
        return getSalary() * 0.10;
    }
}

class InternStudent extends AbstractWorker {
    InternStudent(String name, double salary) {
        super(name, salary);
    }
}
