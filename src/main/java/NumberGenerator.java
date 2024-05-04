import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

  public static List<Integer> generateRandomNumber() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    List<Integer> answer = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      int index = random.nextInt(numbers.size());
      answer.add(numbers.remove(index));
    }
    return answer;
  }

}
