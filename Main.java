import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Become A Developer 2023" (summer course)
 * @author Maksym Reva
 * @version 1.0.0
 * JDK version - 17
 */
public class Main {

    /**
     * Algorithm:
     *  1. Split text samples by words and collect them into List, array, e.t.c;
     *  2. Find first unique char in each word and add them into one String(StringBuilder, StringJoiner);
     *  3. Use the same function as p.3 to find first unique char in that String.
     */

    public static void main(String[] args) {
        // Your text sample
        var textSample = """
                The Tao gave birth to machine language.  Machine language gave birth
                to the assembler.
                The assembler gave birth to the compiler.  Now there are ten thousand
                languages.
                Each language has its purpose, however humble.  Each language
                expresses the Yin and Yang of software.  Each language has its place within
                the Tao.
                But do not program in COBOL if you can avoid it.
                        -- Geoffrey James, "The Tao of Programming"
                """;
        List<String> words = Arrays.stream(textSample.split("\\W+"))
                                    .collect(Collectors.toList());
        System.out.println(words);
        String uniqChars = collectFirstUniqChars(words);
        char uniqChar = findUniqCharInSequence(uniqChars);
        System.out.println("\nFirst unique character from a sequence of first unique characters: " + uniqChar);
    }

    private static String collectFirstUniqChars(List<String> words) {
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            var ch = findUniqCharInSequence(word);
            System.out.printf("%s ", ch);
            builder.append(ch);
        }
        return builder.toString();
    }

    private static char findUniqCharInSequence(String word) {
        for (char element : word.toCharArray()) {
            int firstOccurrenceIndex = word.indexOf(Character.toString(element));
            int lastOccurrenceIndex = word.lastIndexOf(Character.toString(element));
            if (firstOccurrenceIndex == lastOccurrenceIndex) {
                return element;
            }
        }
        return 0;
    }
}
