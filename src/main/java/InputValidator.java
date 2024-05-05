import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {
  public static List<Integer> validate(String input) {
    if (!isValid(input)) {
      throw new IllegalArgumentException();
    }
    return stringToList(input);
  }

  /// 형식에 맞는지
  public static boolean isValid(String input) {
    if (input.length() != 3) {
      return false;
    }
    Set<Character> digits = new HashSet<>();
    for (char c : input.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
      if (!digits.add(c)) {
        return false;
      }
    }
    return true;
  }


  /// String으로 된 숫자를 List로 변경
  public static List<Integer> stringToList(String input) {
    return input.chars()
        .map(Character::getNumericValue)
        .boxed()
        .collect(Collectors.toList());
  }
}
