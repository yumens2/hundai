package baseball.model;

import java.util.List;
import java.util.Random;

public class Computer {

    private List<Integer> answer;

    public void init() {
        Random random = new Random();

        while (answer.size() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }
}
