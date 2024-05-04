import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InitNumbers {

    private String numbers = "";

    public InitNumbers() {
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        Collections.shuffle(temp);
        this.numbers = Integer.toString(temp.get(0)) + Integer.toString(temp.get(1)) + Integer.toString(temp.get(2));
    }

    public String getNumbers() {
        return numbers;
    }
}
