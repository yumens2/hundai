import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final Scanner scanner = new Scanner(System.in);
    final List<Integer> computerNumbers = new ArrayList<>();

    public void gamePlay() {

        boolean continuePlaying = true;

        while (continuePlaying) {
            computerGenerateNumbers();
            System.out.println(computerNumbers);
            boolean correctNumber = false;
            while (!correctNumber) {
                System.out.print("숫자를 입력해 주세요 : ");
                try {
                    String input = scanner.nextLine();
                    correctNumber = ballOrStrike(input);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            continuePlaying = askForNewGame();
        }
    }

    private void computerGenerateNumbers() {
        computerNumbers.clear();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < 3; i++) {
            computerNumbers.add(numbers.get(i));
        }
    }

    boolean ballOrStrike(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }

        int strikes = 0, balls = 0;

        for (int i = 0; i < 3; i++) {

            int number = Character.getNumericValue(input.charAt(i));

            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
            if (number == computerNumbers.get(i)) {
                strikes++;
            } else if (computerNumbers.contains(number)) {
                balls++;
            }
        }

        if (strikes == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;

        } else {

            StringBuilder result = new StringBuilder();

            if (balls > 0) {
                result.append(balls).append("볼 ");
            }
            if (strikes > 0) {
                result.append(strikes).append("스트라이크");
            }
            if (balls == 0 && strikes == 0) {
                result.append("낫싱");
            }

            System.out.println(result);

            return false;
        }
    }

    private boolean askForNewGame() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입락하세요.");
        String ans = scanner.nextLine();
        return "1".equals(ans);
    }

}