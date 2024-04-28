import java.util.Random;

public class RandomNumberGenerator {

    public String getRandomNumber() {
        String randomNumber = new String("");
        while (randomNumber.length() < 3) {
            appendRandomSingleDigit(randomNumber);
        }
        return randomNumber;
    }

    public void appendRandomSingleDigit(String number) {
        Random randomGenerator = new Random();
        String randomSingleDigit = Integer.toString(randomGenerator.nextInt(9) + 1);
        if (!number.contains(randomSingleDigit)){
            number += randomSingleDigit;
        }
    }
}
