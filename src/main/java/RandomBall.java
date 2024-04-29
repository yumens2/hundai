import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomBall implements Random{

    @Override
    public int makeRandomBall() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        StringBuilder randomNumberBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            randomNumberBuilder.append(numbers.get(i));
        }

        int randomNumber = Integer.parseInt(randomNumberBuilder.toString());

        return randomNumber;
    }
}
