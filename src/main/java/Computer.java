import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> makeRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            Integer randomNumber = (int)(Math.random() * 9) + 1;
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }
}
