import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    public static String getRandomNumber() {
        List<String> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            appendRandomSingleDigit(randomNumberList);
        }
        return String.join("", randomNumberList);
    }

    public static void appendRandomSingleDigit(List<String> numberList) {
        Random randomGenerator = new Random();
        String randomSingleDigit = Integer.toString(randomGenerator.nextInt(9) + 1);
        if (!numberList.contains(randomSingleDigit)){
            numberList.add(randomSingleDigit);
        }
    }
}
