package computer;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Computer {

    private String number;

    public Computer() {
        number = createBaseballNumber();
    }

    private String createBaseballNumber(){
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();

        while(numbers.size() < 3){
            int randomNumber = random.nextInt(9) + 1;
            numbers.add(randomNumber);
        }

        String createNumber = "";
        for (Integer num : numbers) {
            createNumber += num;
        }

        return createNumber;
    }
}
