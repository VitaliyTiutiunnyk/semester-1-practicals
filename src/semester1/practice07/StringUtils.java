package semester1.practice07;

import static java.util.Collections.reverse;

public class StringUtils {
    private StringUtils() {
    }
    public static boolean isPalindrome(String s) {
        s = s.replace(" ", "").toLowerCase();

        String reversed = reverse(s);

        return s.equals(reversed);
    }
    public static String reverse(String s) {
        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }

        return result;
    }
    public static int countVowels(String s) {
        int count = 0;
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ("аеєиіїоуюяaeiou".indexOf(ch) != -1) {
                count++;
            }
        }

        return count;
    }
    public static String maskCardNumber(String cardNumber) {
        String digits = cardNumber.replaceAll("\\D", "");
        if (digits.length() < 4) {
            return cardNumber;
        }
        String lastFour = digits.substring(digits.length() - 4);
        String result = "";

        for (int i = 0; i < digits.length() - 4; i++) {
            result += "*";

            if ((i + 1) % 4 == 0) {
                result += " ";
            }
        }
        return result + lastFour;
    }



}
