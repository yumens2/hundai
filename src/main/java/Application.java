
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application{

    public boolean containsDuplicate(List<Integer> digits) {
        return digits.stream().distinct().count() != digits.size();
    }
    public List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }
    public List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 3);
    }
    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void validateUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }

        List<Integer> digits = parseInput(userInput);
        if (containsDuplicate(digits)) {
            throw new IllegalArgumentException("중복되지 않은 3자리 숫자를 입력하세요.");
        }
    }





}
