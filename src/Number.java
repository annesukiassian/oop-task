import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Number {

    private String inputNumber;
    private final Map<String, String[]> letterMap = new HashMap<>();

    public Number(String inputNumber) {
        this.inputNumber = inputNumber;
        initializeMap();
    }

    private void initializeMap() {
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
        letterMap.put(null, new String[]{" "});
    }


    public ArrayList<String[]> initializeLetterArray() {

        ArrayList<String[]> workingArray = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            switch (inputNumber.charAt(i)) {
                case '0':
                    workingArray.add(letterMap.get("0"));
                    break;
                case '1':
                    workingArray.add(letterMap.get("1"));
                    break;
                case '2':
                    workingArray.add(letterMap.get("2"));
                    break;
                case '3':
                    workingArray.add(letterMap.get("3"));
                    break;
                case '4':
                    workingArray.add(letterMap.get("4"));
                    break;
                case '5':
                    workingArray.add(letterMap.get("5"));
                    break;
                case '6':
                    workingArray.add(letterMap.get("6"));
                    break;
                case '7':
                    workingArray.add(letterMap.get("7"));
                    break;
                case '8':
                    workingArray.add(letterMap.get("8"));
                    break;
                case '9':
                    workingArray.add(letterMap.get("9"));
                    break;
                case ' ':
                    workingArray.add(letterMap.get(null));
                    break;
            }
        }

        return workingArray;
    }
}
