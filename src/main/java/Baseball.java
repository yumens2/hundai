import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baseball {
  private static final Integer NUM_LEN = 3;

  public static Integer[] initAnswerNums() {
    Integer availableNums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    Integer answerNums[] = new Integer[NUM_LEN];
    List<Integer> list = Arrays.asList(availableNums);
    Collections.shuffle(list);

    for (int index = 0; index < NUM_LEN; index++) {
      answerNums[index] = list.get(index);
    }
    return answerNums;
  }
}
