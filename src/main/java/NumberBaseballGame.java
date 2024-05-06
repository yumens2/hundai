import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {

    private List<Integer> parseInput(String input) throws IllegalArgumentException {
        String[] tokens = input.split("\\s+");
        if (tokens.length != 3) throw new IllegalArgumentException("Exactly three numbers are required.");

        List<Integer> userNumbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 1 || number > 9) throw new IllegalArgumentException("Numbers must be between 1 and 9.");
            if (userNumbers.contains(number)) throw new IllegalArgumentException("Duplicate numbers are not allowed.");
            userNumbers.add(number);
        }
        return userNumbers;
    }
}