import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    public int checkStrike(List<Integer> randomNumber, int predictNumber) {
        int count = 0;
        List<Integer> predictNumberList = getIntegerList(predictNumber);
        for (int i = 0; i < 3; i++) {
            if (randomNumber.get(i) == predictNumberList.get(i)) {
                count += 1;
            }
        }
        return count;
    }

    public int checkBall(List<Integer> randomNumber, int predictNumber) {
        int count = 0;
        List<Integer> predictNumberList = getIntegerList(predictNumber);
        for (int i = 0; i < 3; i++) {
            if (randomNumber.contains(predictNumberList.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    private static List<Integer> getIntegerList(int predictNumber) {
        String number = Integer.toString(predictNumber);
        List<String> numberList = Arrays.asList(number.split(""));
        List<Integer> predictNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            predictNumberList.add(Integer.valueOf(numberList.get(i)));
        }
        return predictNumberList;
    }
}
