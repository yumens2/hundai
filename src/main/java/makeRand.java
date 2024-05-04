import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class makeRand {
    public List<Integer> makeRandNum() {

        Random rand = new Random();
        List<Integer> randomNum = new ArrayList<>();

        while (randomNum.size() < 3) {
            int inputNum = rand.nextInt(9) + 1;
            if (randomNum.contains(inputNum)) {
                continue;
            } else {
                randomNum.add(inputNum);
            }
        }
        return randomNum;
    }
}
