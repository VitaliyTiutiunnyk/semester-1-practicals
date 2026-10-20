package semester1.practice06;

import java.util.Locale;

public class TextFormatter {
    public String formatTitle(String text){
        return "*** "+text.toLowerCase()+" ***";
    }
    public int countVowels(String text){
        int count = 0;
        String vowels = "аоуеиіяюєїaeiou";

        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }

        return count;


    }
}
