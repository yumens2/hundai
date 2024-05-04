import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

  public static List<Integer> generateRandomNumber() {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    Collections.shuffle(numbers);
    return numbers.subList(0, 3);
  }
}
