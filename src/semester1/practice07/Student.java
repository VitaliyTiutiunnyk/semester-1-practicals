package semester1.practice07;

public class Student {
    private String name;
    private int age;
    private double gpa;
  public   Student(String name, int age, double gpa){
        this.name=name;
        this.age=age;
        this.gpa=gpa;
        if (this.age<15 || this.age>80){
            this.age=18;
        }
        if (this.gpa<0.0||gpa>5.0){
            this.gpa=0.0;
        }
    }
    public boolean isHonorStudent(){
      return gpa>=4.5;
    }
    public void printStudent(){
        System.out.println("Ім'я: "+name+"| Вік: "+age);
        System.out.println("Середній бал:"+gpa+"| Відмінник: "+isHonorStudent());
    }

}
