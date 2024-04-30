import java.util.*;

public class NumberGenerating {

    public Set<Integer> generateRandomNumber() {
        Set<Integer> numbers = new LinkedHashSet<>();
        Random random = new Random();
        while (numbers.size() < 3){
            numbers.add(random.nextInt(1, 10));
        }
        return numbers;
    }

    public ArrayList<Integer> inputUserNumber(Scanner scanner) {
        ArrayList<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNumber.add(scanner.nextInt());
        }
        return userNumber;
    }
}
