package semester1.practice09;

import java.util.Arrays;

public class Task08 {
    public static void run(){
        String[] allergies = {"Пилок", "Арахіс", "Мед"};

        MedicalRecord record = new MedicalRecord(
                "P001", "Іван Петренко", 2, true, allergies
        );

        System.out.println(record);

        System.out.println("\nПеревірка алергій:");
        System.out.println("Пилок: " + record.hasAllergyTo("Пилок"));
        System.out.println("Молоко: " + record.hasAllergyTo("Молоко"));

        System.out.println("\nПеревірка захисного копіювання:");
        allergies[0] = "Вода";
        System.out.println(record.getAllergies() == allergies);
        System.out.println(Arrays.toString(record.getAllergies()));

    }
}
class MedicalRecord {
    private final String patientId;
    private String fullName;
    private int bloodGroup;
    private boolean rhPositive;
    private String[] allergies;

    MedicalRecord(String patientId, String fullName, int bloodGroup,
                  boolean rhPositive, String[] allergies) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        if (bloodGroup < 1 || bloodGroup > 4) {
            this.bloodGroup = 1;
        }
        this.rhPositive = rhPositive;
        this.allergies = Arrays.copyOf(allergies, allergies.length);
    }

    public String[] getAllergies() {
        return Arrays.copyOf(allergies, allergies.length);
    }

    public boolean hasAllergyTo(String substance) {
        for (String allergy : allergies) {
            if (substance.equals(allergy)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String group = switch (bloodGroup) {
            case 2 -> "II (A)";
            case 3 -> "III (B)";
            case 4 -> "IV (AB)";
            default -> "I (0)";
        };

        return STR."""
Пацієнт: \{fullName}
Група крові: \{group} Rh\{rhPositive ? "+" : "-"}
Алергії: \{Arrays.toString(allergies)}""";
    }
}