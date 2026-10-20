package semester1.practice06;

public class Person {
    private String name;
    private int age;
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        if (age>=0&&age<=120){
            this.age=age;
        }
    }
    public void printSummary(){
        System.out.println("Ім'я: "+name);
        System.out.println("Вік: "+age);

    }
}
