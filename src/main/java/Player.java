import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Integer> number = new ArrayList<>();

    public List<Integer> getNumber() {
        return number;
    }

    public void inputNumber() {
        String input;

        System.out.print("숫자를 입력해 주세요 : ");
        input = scanner.nextLine();
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("잘못된 입력: 유효한 입력은 0이 포함되지 않은 3자리 수 입니다");
        }
        number.clear();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int digit = Character.getNumericValue(c);
            number.add(digit);
        }
    }

    public int inputMenu() {
        String input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = scanner.nextLine();
        if (Objects.equals(input, "1") || Objects.equals(input, "2")) {
            return Integer.parseInt(input);
        }
        else {
            throw new IllegalArgumentException("잘못된 입력: 유효한 입력은 1 혹은 2입니다");
        }
    }

    public void printScore(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        else if (ball != 0) {
            System.out.println(ball + "볼 ");
        }
        else if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        else {
            System.out.println("낫싱");
        }
    }
}
