import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberBaseballGame {

    private final List<Integer> computerNumbers;
    private boolean gameWon = false;

    public NumberBaseballGame(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public boolean play() {
        Scanner scanner = new Scanner(System.in);
        while (!gameWon) {
            System.out.print("숫자를 입력해 주세요: ");
            try {
                String input = scanner.nextLine();
                List<Integer> userNumbers = parseInput(input);

                String result = checkNumbers(userNumbers);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Application will terminate.");
                break;
            }
        }

        if(gameWon) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String option = scanner.nextLine();
        return option.trim().equals("1");
    }

    private List<Integer> parseInput(String input) throws IllegalArgumentException {
        String[] tokens = input.split("\\s+");
        if (tokens.length != 3) throw new IllegalArgumentException("Exactly three numbers are required.");

        List<Integer> userNumbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 1 || number > 9) throw new IllegalArgumentException("Numbers must be between 1 and 9.");
            if (userNumbers.contains(number)) throw new IllegalArgumentException("Duplicate numbers are not allowed.");
            userNumbers.add(number);
        }
        return userNumbers;
    }

    private String checkNumbers(List<Integer> userNumbers) {
        int strikes = 0, balls = 0;
        for (int i = 0; i < 3; i++) {
            int userNumber = userNumbers.get(i);
            if (userNumber == computerNumbers.get(i)) strikes++;
            else if (computerNumbers.contains(userNumber)) balls++;
        }

        if(strikes == 3) gameWon = true;

        if (strikes == 0 && balls == 0) return "낫싱";
        else if(strikes == 0) return balls + " 볼";
        else if(balls == 0) return strikes + "스트라이크";
        else return balls + " 볼 " + strikes + "스트라이크";
    }
}