import java.util.HashMap;
import java.util.Map;

public class Number {

    private String inputNumber;
    private final Map<String, String[]> letterMap = new HashMap<>();

    public Number(String inputNumber) {
        this.inputNumber = inputNumber;
        letterMap.put("0", new String[]{"0"});
        letterMap.put("1", new String[]{"1"});
        letterMap.put("2", new String[]{"A", "B", "C"});
        letterMap.put("3", new String[]{"D", "E", "F"});
        letterMap.put("4", new String[]{"G", "H", "I"});
        letterMap.put("5", new String[]{"J", "K", "L"});
        letterMap.put("6", new String[]{"M", "N", "O"});
        letterMap.put("7", new String[]{"P", "Q", "R", "S"});
        letterMap.put("8", new String[]{"T", "U", "V"});
        letterMap.put("9", new String[]{"W", "X", "Y", "Z"});
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public Map<String, String[]> getLetterMap() {
        return letterMap;
    }
}
