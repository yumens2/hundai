package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerNum {
    private List<Integer> computerNumbers = new ArrayList<>();

    public void generateComputerNumbers() {
        computerNumbers.clear();
        Random random = new Random();
        while (computerNumbers.size() < 3) {
            int digit = random.nextInt(9) + 1;  // numbers from 1 to 9
            if (!computerNumbers.contains(digit)) {
                computerNumbers.add(digit);
            }
        }
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}