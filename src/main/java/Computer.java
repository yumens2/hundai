import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Computer {
    private List<Integer> number = generateRandomNumber();

    private List<Integer> generateRandomNumber() {
        List<Integer> digit = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(digit);
        return digit.subList(0, 3);
    }

    public void setNumber() {
        number = generateRandomNumber();
    }

    public List<Integer> getNumber() {
        return number;
    }
}
