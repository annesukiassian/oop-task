import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Please enter your phone number -> ");
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();
        WordGenerator wordGenerator = new WordGenerator();
        List<String> possibleWordsCombination = wordGenerator.getPossibleLettersCombination(inputNumber);
        System.out.println(possibleWordsCombination.size());
        System.out.println(possibleWordsCombination);

    }

}
