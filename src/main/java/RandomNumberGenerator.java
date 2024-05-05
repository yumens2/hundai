import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generate(){

        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            result.add(numbers.get(i));
        }
        return result;
    }
}
