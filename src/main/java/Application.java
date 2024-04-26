import java.util.Random;

public class Application {

    public static void main(String[] args) {
        while (true) {
            String opponentRandomNumber = generateRandomNumber();

        }
    }

    public static String generateRandomNumber() {
        StringBuilder randomNumberBuilder = new StringBuilder();
        Random randomNumberGenerator = new Random();
        for (int i = 0; i < 3; i++) {
            String randomDigitNumber = String.valueOf(randomNumberGenerator.nextInt(9) + 1);
            if (!randomNumberBuilder.toString().contains(randomDigitNumber)){
                randomNumberBuilder.append(randomDigitNumber);
            }
        }
        return randomNumberBuilder.toString();
    }
}
