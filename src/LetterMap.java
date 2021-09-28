import java.util.HashMap;
import java.util.Map;

public class LetterMap {

    private static final LetterMap instance;
    private final Map<String, String[]> letters = new HashMap<>();

    private LetterMap() {
        letters.put(" ", new String[]{" "});
        letters.put("0", new String[]{"0"});
        letters.put("1", new String[]{"1"});
        letters.put("2", new String[]{"A", "B", "C"});
        letters.put("3", new String[]{"D", "E", "F"});
        letters.put("4", new String[]{"G", "H", "I"});
        letters.put("5", new String[]{"J", "K", "L"});
        letters.put("6", new String[]{"M", "N", "O"});
        letters.put("7", new String[]{"P", "Q", "R", "S"});
        letters.put("8", new String[]{"T", "U", "V"});
        letters.put("9", new String[]{"W", "X", "Y", "Z"});
    }

    static {
        try {
            instance = new LetterMap();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public Map<String, String[]> getLetters() {
        return letters;
    }

    public static String[] getMatchingLettersForNumber(String number) {
        if (instance.getLetters().containsKey(number)) {
            return instance.getLetters().get(number);
        } else {
            throw new InvalidInputException("Can't find symbol list for the given number");
        }
    }

}
