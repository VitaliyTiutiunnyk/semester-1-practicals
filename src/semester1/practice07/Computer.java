package semester1.practice07;

public class Computer {
   private String title;
   private Processor cpu;
   private Memory ram;
   private double casePrice;
    Computer(String title, Processor cpu, Memory ram, double casePrice){
        this.title=title; this.cpu=cpu;
        this.ram=ram; this.casePrice=casePrice;
    }
    public double calculateTotalPrice(){
        return cpu.getPrice() + ram.getPrice() + casePrice;
    }
    public void upgradeMemory(Memory newRam){
        ram=newRam;
        System.out.println("Апгрейд успішний нова пам'ять - "+ram.sizeGB+" GB");
    }
    public void printSpecs(){
        System.out.println("Комп'ютер: " + title);
        System.out.println("Процесор: " + cpu.getModel());
        System.out.println("Оперативна пам'ять: " + ram.sizeGB + " GB");
        System.out.println("Частота пам'яті: " + ram.frequencyMHz + " MHz");
        System.out.println("Ціна корпусу: " + casePrice + " грн");
        System.out.println("Загальна ціна: " + calculateTotalPrice() + " грн");

    }


}
