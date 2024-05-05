package controller;

import java.util.*;

public class InputController {
    public ArrayList<Integer> generateUserNum() {
        ArrayList<Integer> userNumber = new ArrayList<>();
        // Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        for (int i = 0; i < 3; i++) {
            // if (scanner.hasNextInt()) {
            //     userNumber.add(scanner.nextInt());
            // } else {
            //     scanner.next();
            //     i = 0;
            // }
        }
        return userNumber;
    }

    public Set<Integer> generateComputerNum() {
        Set<Integer> numbers = new LinkedHashSet<>();
        Random random = new Random();
        while (numbers.size() < 3) {
            numbers.add(random.nextInt(1, 10));
        }
        return numbers;
    }
}
