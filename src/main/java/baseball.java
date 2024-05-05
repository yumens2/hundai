import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class baseball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame(scanner);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = scanner.nextInt();
            playAgain = choice == 1;
        } while (playAgain);

        System.out.println("프로그램 종료!");
        scanner.close();
    }

    public static void playGame(Scanner scanner) {
        int[] player;
        int[] computer = generateComputerNumbers();
        int strikes, balls;

        do {
            player = getPlayerInput(scanner);

            strikes = strikeCheck(player, computer);
            balls = ballCheck(player, computer);

            String resultMessage = resultPrint(strikes, balls);
            System.out.println(resultMessage);

        } while (strikes != 3);
    }

    public static int[] getPlayerInput(Scanner scanner) {
        int[] player;
        int[] computer = generateComputerNumbers();
        int strikes, balls;

        do {
            System.out.println("숫자를 입력해 주세요 : ");
            String input = scanner.next();
            player = convertInputToArray(input);

            if (!checkInputValidity(player)) {
                System.out.println("서로 다른 세 자리 숫자를 입력하세요.");
                System.exit(0); // 프로그램 종료
            }

        } while (!checkInputValidity(player));

        return player;
    }

    public static int[] convertInputToArray(String input) {
        try {
            return Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 입력이 있을 경우 예외 처리
            System.out.println("올바른 숫자를 입력하세요.");
            return new int[0]; // 유효하지 않은 입력은 빈 배열로 반환
        }
    }

}