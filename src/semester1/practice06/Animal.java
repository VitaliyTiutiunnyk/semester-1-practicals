package semester1.practice06;

public class Animal {
    String species;
    String name;
    public void makeSound(){
        System.out.println(name+" видає звук!");

    }
    public void printInfo(){
        System.out.println("Вид: "+species);
        System.out.println("Кличка: "+name);
    }
}
