import java.util.ArrayList;
import java.util.Scanner;

public class WordGenerator {


    public void generate() {

        System.out.print("Please enter your phone number -> ");
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();

        //checks if input contains at least one number, and it might contain spaces
        if (inputNumber.matches("^ *[0-9][0-9 ]*$") && inputNumber.length() > 0) {

            Number number = new Number(inputNumber);

            ArrayList<String[]> workingArray = number.initializeLetterArray();
            printPossibleWords(workingArray);

            System.out.println("End");

        } else {
            throw new InvalidInputException("The input should include numbers from 0 to 9");
        }
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