import java.util.Arrays;
import java.util.Objects;

public class Number {

    private String number;
    private String[] numberMatchingCharacters;

    public Number(final String number) {
        this.number = number;
        this.numberMatchingCharacters = LetterMap.getMatchingLettersForNumber(number).clone();
    }

    public String getNumber() {
        return number;
    }

    public Number setNumber(String number) {
        this.number = number;
        return this;
    }

    public String[] getNumberMatchingCharacters() {
        return numberMatchingCharacters;
    }

    public Number setNumberMatchingCharacters(String[] numberMatchingCharacters) {
        this.numberMatchingCharacters = numberMatchingCharacters;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number) && Arrays.equals(numberMatchingCharacters, number1.numberMatchingCharacters);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(numberMatchingCharacters);
        return result;
    }

}
