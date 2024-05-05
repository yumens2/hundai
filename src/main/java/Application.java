
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application{
    public static void main(String[] args) {
        Application game = new Application();
        game.startGameFlow();
    }

    public void startGameFlow() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean playAgain = true;
            while (playAgain) {
                playSingleGame(scanner);
                playAgain = askPlayAgain(scanner);
            }
        }
    }

    public void playSingleGame(Scanner scanner) {
        List<Integer> computerNumbers = generateRandomNumbers();
        System.out.println("새 게임을 시작합니다.");

        while (!gameIsFinished(computerNumbers, scanner)) {
            // continue playing until baseballgame.GameTest.game is finished
        }
    }

    public boolean gameIsFinished(List<Integer> computerNumbers, Scanner scanner) {
        List<Integer> userNumbers = getUserNumbers(scanner);
        Result result = compareNumbers(computerNumbers, userNumbers);
        System.out.println(result);

        if (result.strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    public List<Integer> getUserNumbers(Scanner scanner) {
        String userInput = requestUserInput(scanner);
        validateUserInput(userInput);
        return parseInput(userInput);
    }

    public String requestUserInput(Scanner scanner) {
        System.out.print("3자리 숫자를 입력해주세요: ");
        return scanner.nextLine();
    }

    public void validateUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }

        List<Integer> digits = parseInput(userInput);
        if (containsDuplicate(digits)) {
            throw new IllegalArgumentException("중복되지 않은 3자리 숫자를 입력하세요.");
        }
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean containsDuplicate(List<Integer> digits) {
        return digits.stream().distinct().count() != digits.size();
    }

    public List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    public List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 3);
    }
    public Result compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {

                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        return new Result(strikes, balls);
    }

    public boolean askPlayAgain(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine().equals("1");
    }

    public static class Result {
        public int strikes;
        public int balls;

        public Result(int strikes, int balls) {
            this.strikes = strikes;
            this.balls = balls;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (strikes > 0) {
                sb.append(strikes).append(" 스트라이크 ");
            }
            if (balls > 0) {
                sb.append(balls).append(" 볼 ");
            }
            if (strikes == 0 && balls == 0) {
                sb.append("낫싱");
            }
            return sb.toString();
        }
    }
}
