package semester1.practice10;

public class Task12 {
    public static void run(){
        EmailValidator emailValidator = new EmailValidator();
        PositiveNumberValidator numberValidator = new PositiveNumberValidator();
        System.out.println(emailValidator.isValid("test@gmail.com"));
        System.out.println(emailValidator.isValid("hello"));
        System.out.println(numberValidator.isValid("25"));
        System.out.println(numberValidator.isValid("-10"));
        System.out.println(emailValidator.validateOrDefault(
                "hello", "Невірний email"));

        System.out.println(numberValidator.validateOrDefault(
                "100", "Невірне число"));

    }
}
interface DataValidator{
    boolean isValid(String input);
    default String validateOrDefault(String input, String fallback){
        if (isValid(input)){
            return input;
        }
        return fallback;
    }
    static boolean isNotNullOrBlank(String s){
        return s != null && !s.isBlank();
    }
}
class EmailValidator implements DataValidator{
    @Override
    public boolean isValid(String input) {
        return DataValidator.isNotNullOrBlank(input)
                && input.contains("@")
                && input.contains(".");
    }
}
class PositiveNumberValidator implements DataValidator {
    @Override
    public boolean isValid(String input) {
        if (!DataValidator.isNotNullOrBlank(input)) {
            return false;
        }

        try {
            return Double.parseDouble(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
