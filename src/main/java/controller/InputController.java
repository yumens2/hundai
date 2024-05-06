package controller;

import java.util.*;

public class InputController {
    public ArrayList<Integer> generateUserNum() {
        ArrayList<Integer> userNumber = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        for (int i = 0; i < 3; i++) {
            if (scanner.hasNextInt()) {
                userNumber.add(scanner.nextInt());
            } else {
                scanner.next();
                i = 0;
            }
        }
        if(userNumber.stream().anyMatch(x->x>10)){
            System.out.println("한자리 수만 입력할 수 있습니다. 다시 입력해주세요");
            userNumber.clear();
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
