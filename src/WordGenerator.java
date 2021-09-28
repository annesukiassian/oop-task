import java.util.ArrayList;
import java.util.List;

public class WordGenerator {

    public List<String> getPossibleLettersCombination(final String inputNumber) {
        //checks if input contains at least one number, and it might contain spaces
        if (inputNumber.matches("^ *[0-9][0-9 ]*$") && inputNumber.length() > 0) {
            // excluding spaces from input
            ArrayList<Number> letters = initializeArray(inputNumber);

            return generatePossibleWords(letters);

        } else {
            throw new InvalidInputException("The input should include numbers from 0 to 9");
        }
    }

    private ArrayList<Number> initializeArray(String inputNumber) {
        System.out.println("Initializing Working Numbers And Letters  Array");
        ArrayList<Number> workingArray = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            workingArray.add(new Number(String.valueOf(inputNumber.charAt(i))));
        }
        System.out.println("Numbers and Letters Array successfully Initialized");
        return workingArray;
    }

    private ArrayList<String> generatePossibleWords(ArrayList<Number> letters) {
        System.out.println("Generating Words");
        // array for indexes
        ArrayList<String> words = new ArrayList<>();
        int indexArraySize = letters.size();
        int[] indexes = new int[indexArraySize];

        // initializing indexes
        for (int i = 0; i < indexArraySize; i++) {
            indexes[i] = 0;
        }

        while (true) {
            StringBuilder stringBuilder = new StringBuilder();
            // printing current combinations
            for (int i = 0; i < indexArraySize; i++) {
                stringBuilder.append(letters.get(i).getNumberMatchingCharacters()[indexes[i]]);
            }
            words.add(stringBuilder.toString());

            // find array which has the most elements after current element
            int next = indexArraySize - 1;
            while (next >= 0 && (indexes[next] + 1 >= letters.get(next).getNumberMatchingCharacters().length)) {
                next--;
            }

            // if there is no such an array, you've checked all the arrays
            if (next < 0) {
                System.out.println("Words successfully generated");
                return words;
            }

            // if found move to next element of that array
            indexes[next]++;

            // index to first element
            for (int i = next + 1; i < indexArraySize; i++) {
                indexes[i] = 0;
            }
        }

    }

}