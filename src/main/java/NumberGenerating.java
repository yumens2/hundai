import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGenerating {

    public ArrayList<Integer> generateRandomNumber() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            numbers.add(random.nextInt(1, 10));
        }
        return numbers;
    }

    public ArrayList<Integer> inputUserNumber() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNumber.add(scanner.nextInt());
        }
        scanner.close();
        return userNumber;
    }
}
