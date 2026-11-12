package semester1.practice10;

public class Task17 {
    public static void run(){
        AbstractBird[] abstractBirds ={
                new Falcon("Гімалайський орел", 35),
                new EmperorPenguin("Імператорський пінгвін", 40)
        };
        FlyableUnit[] units = {
                new CargoPlane("Мрія"),
                new Falcon("Сапсан", 1.5)
        };
        System.out.println("Літаючі об'єкти: ");
        for (FlyableUnit unit : units){
            System.out.println("Вид об'єкта: "+unit.getClass().getSimpleName());
            System.out.println("Швидкість: "+unit.getFlightSpeedKmh());
        }
        System.out.println("\nПтахи: ");
        for (AbstractBird bird : abstractBirds){
            System.out.println("Вид: " + bird.species);
            System.out.println("Вага: " + bird.weightKg);
            System.out.println(bird.makeSound());
            if (bird instanceof SwimmingUnit swimmer) {
                System.out.println("Глибина занурення: "
                        + swimmer.getDiveDepthMeters() + " м");
            }
            if (bird instanceof FlyableUnit flyableUnit){
                System.out.println("Швидкість польоту птаха: "+
                        flyableUnit.getFlightSpeedKmh());
            }
        }


    }
}
abstract class AbstractBird{
    protected final String species;
    protected double weightKg;
    AbstractBird(String species, double weightKg){
        this.species=species;
        this.weightKg=weightKg;
    }
    public abstract String makeSound();
}
interface FlyableUnit{
    double getFlightSpeedKmh();
}
interface  SwimmingUnit{
    double getDiveDepthMeters();
}
class Falcon extends AbstractBird implements FlyableUnit{
    Falcon(String species, double weightKg){
        super(species, weightKg);
    }
    @Override
    public double getFlightSpeedKmh() {
        return 80 ;
    }

    @Override
    public String makeSound() {
        return "Птах співає";
    }
}
class EmperorPenguin extends AbstractBird implements SwimmingUnit{
    EmperorPenguin(String species, double weightKg){
        super(species, weightKg);
    }
    @Override
    public double getDiveDepthMeters() {
        return 3;
    }

    @Override
    public String makeSound() {
        return "Пінгвін мовчить:(";
    }
}
class CargoPlane implements FlyableUnit{
    private String name;
    CargoPlane(String name){
        this.name=name;
    }

    @Override
    public double getFlightSpeedKmh() {
        return 400;
    }
}
