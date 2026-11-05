package semester1.practice09;

public class Task22 {
    public static void run(){
        UniversityCourse course = new UniversityCourse("Java Programming", 5);
        CourseModule module1 = new CourseModule("Основи Java", 30, 30, 30);
        CourseModule module2 = new CourseModule("ООП", 40, 40, 40);
        CourseModule module3 = new CourseModule("Колекції Java", 20, 20, 30);
        course.addModule(module1);
        course.addModule(module2);
        course.addModule(module3);
        System.out.println(course);
    }
}
class CourseModule{
    private final String topic;
    private final int lectureHours;
    private final int practiceHours;
    private double maxScore;
    CourseModule(String topic, int lectureHours, int practiceHours, double maxScore){
        this.topic=topic;
        this.lectureHours=lectureHours;
        this.practiceHours=practiceHours;
        this.maxScore=maxScore;
    }
    public int getTotalHours() {
        return lectureHours + practiceHours;
    }
    public double getMaxScore() {
        return maxScore;
    }
    @Override
    public String toString() {
        return "Тема: " + topic +
                "\nЛекційні години: " + lectureHours +
                "\nПрактичні години: " + practiceHours +
                "\nМаксимальний бал: " + maxScore;
    }
}
class UniversityCourse {
    private final String courseTitle;
    private final CourseModule[] modules;
    private int moduleCount;

    UniversityCourse(String courseTitle, int capacity) {
        this.courseTitle = courseTitle;
        modules = new CourseModule[capacity];
    }
    public void addModule(CourseModule module) {
        if (module != null && moduleCount < modules.length) {
            modules[moduleCount] = module;
            moduleCount++;
        }
    }
    public double getTotalCredits() {
        int totalHours = 0;
        for (int i = 0; i < moduleCount; i++) {
            totalHours += modules[i].getTotalHours();
        }
        return totalHours / 30.0;
    }
    public boolean isScoreValid() {
        double total = 0;

        for (int i = 0; i < moduleCount; i++) {
            total += modules[i].getMaxScore();
        }
        return total == 100.0;
    }
    @Override
    public String toString() {
        String result = "=== НАВЧАЛЬНИЙ КУРС ===\n";
        result += "Назва курсу: " + courseTitle + "\n";

        for (int i = 0; i < moduleCount; i++) {
            result += "\nМодуль №" + (i + 1) + "\n";
            result += modules[i].toString() + "\n";
        }

        result += "\nЗагальна кількість кредитів ЄКТС: " + getTotalCredits();
        result += "\nСума балів дорівнює 100: " + (isScoreValid() ? "Так" : "Ні");

        return result;
    }
}
