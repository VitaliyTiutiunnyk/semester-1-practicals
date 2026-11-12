package semester1.practice10;

public class Task24 {
    public static void run(){
        TextProcessor[] processors = {
                new CaesarCipherProcessor(3),
                new WhitespaceTrimmerProcessor()
        };
        String text = "  Hello    World!  ";
        System.out.println("\nПочатковий текст: [" + text + "]");
        for (TextProcessor processor : processors) {
            text = processor.process(text);
            System.out.println("Після " + processor.getClass().getSimpleName()
                    + ": [" + text + "]");
        }
        System.out.println("\nЗворотна обробка:");
        for (int i = processors.length - 1; i >= 0; i--) {
            if (processors[i] instanceof ReversibleProcessor reversible) {
                text = reversible.reverseProcess(text);
                System.out.println("Після зворотної операції: [" + text + "]");
            }
        }
    }
}
interface TextProcessor {
    String process(String text);
}

interface ReversibleProcessor extends TextProcessor {
    String reverseProcess(String text);
}

class CaesarCipherProcessor implements ReversibleProcessor {
    private final int k;

    CaesarCipherProcessor(int k) {
        this.k = k;
    }

    @Override
    public String process(String text) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append((char) ('a' + (c - 'a' + k) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                result.append((char) ('A' + (c - 'A' + k) % 26));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    @Override
    public String reverseProcess(String text) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append((char) ('a' + (c - 'a' - k + 26) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                result.append((char) ('A' + (c - 'A' - k + 26) % 26));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
class WhitespaceTrimmerProcessor implements TextProcessor {
    @Override
    public String process(String text) {
        return text.trim().replaceAll("\\s+", " ");
    }
}
