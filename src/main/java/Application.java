import java.util.Scanner;

public class Application {

    /**
     * Play the game
     *
     * @param logic Logic object to play the game
     * @param sc    Scanner object to get user input
     * @return 1 if the game is not over, 2 if the game is over
     */
    private static int play(Logic logic, Scanner sc) {
        System.out.print("숫자를 입력해 주세요 : ");
        int userNumber = Utils.InputToRightInteger(sc.nextLine());
        int strike = logic.isStrike(userNumber);
        int ball = logic.isBall(userNumber);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 2;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return 1;
    }

    /**
     * Ask user if they want to stop the game
     *
     * @param logic Logic object to reset the game
     * @param sc    Scanner object to get user input
     * @return true if user wants to stop the game, false if user wants to continue
     */
    private static boolean askStop(Logic logic, Scanner sc) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = sc.nextLine();
        if (input.equals("1")) {
            logic.init();
            return false;
        } else if (input.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    public static void main(String[] args) {
        Logic logic = new Logic();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int game = play(logic, sc);
            if (game == 2 && askStop(logic, sc)) {
                break;
            }
        }
    }
}