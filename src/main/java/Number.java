import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Number {
    public String create() {
        int value = 0;

        HashSet<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() < 3) {
            int randomNumber = random.nextInt(10) + 1;
            numbers.add(randomNumber);
        }

        int i = 0;
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            value += Math.pow(10, i) * iterator.next();
            i++;
        }
        
        return Integer.toString(value);
    }
}