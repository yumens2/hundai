import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
  public static List<Integer> validate(String input) {
    if (!isValid(input)) {
      throw new IllegalArgumentException();
    }
    return stringToList(input);
  }

  public static boolean isValid(String input) {
    if (input.length() != 3) {
      return false;
    }
    for (char c : input.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  private static List<Integer> stringToList(String input) {
    return input.chars()
        .map(Character::getNumericValue)
        .boxed()
        .collect(Collectors.toList());
  }
}
