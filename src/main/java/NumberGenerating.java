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
}
