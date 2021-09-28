import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class WordGenerator {


    public void start() {

        System.out.print("Please enter your phone number -> ");
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();

        //checks if input contains at least one number, and it might contain spaces
        if (inputNumber.matches("^ *[0-9][0-9 ]*$") && inputNumber.length() > 0) {

            // excluding spaces from input
            inputNumber.replace(" ", "");
            Number number = new Number(inputNumber);
            ArrayList<String[]> letters = initializeArray(number);

            System.out.println("Start");
            printPossibleWords(letters);
            System.out.println("End");

        } else {
            throw new InvalidInputException("The input should include numbers from 0 to 9");
        }
    }

    private ArrayList<String[]> initializeArray(Number number) {

        String inputNumber = number.getInputNumber();

        Map<String, String[]> letterMap = number.getLetterMap();

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
            }
        }

        return workingArray;
    }

    private void printPossibleWords(ArrayList<String[]> letters) {

        // array for indexes
        int indexArraySize = letters.size();
        int[] indexes = new int[indexArraySize];

        // initializing indexes
        for (int i = 0; i < indexArraySize; i++) {
            indexes[i] = 0;
        }

        while (true) {

            // printing current combinations
            for (int i = 0; i < indexArraySize; i++) {
                System.out.print(letters.get(i)[indexes[i]]);
            }
            System.out.println();

            // find array which has the most elements after current element
            int next = indexArraySize - 1;
            while (next >= 0 && (indexes[next] + 1 >= letters.get(next).length)) {
                next--;
            }

            // if there is no such an array, you've checked all the arrays
            if (next < 0) {
                return;
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