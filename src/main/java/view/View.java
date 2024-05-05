package view;

import java.io.PrintStream;
import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);

    private View() {

    }

    /**
     * 유저에게 응답을 입력받는 프롬프트를 출력한다
     * @return 유저가 입력한 응답
     */
    public static String getUserGuess() {
        String strUserInput;
        System.out.print("숫자를 입력하세요 : ");
        strUserInput = scanner.nextLine();
        return strUserInput;
    }

    /**
     * 볼과 스트라이크의 개수를 출력한다
     * @param nBall 볼의 개수
     * @param nStrike 스트라이크의 개수
     */
    public static void printResult(int nBall, int nStrike) {
        if (nBall == 0 && nStrike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (nBall > 0) {
            System.out.print(nBall + "볼");
        }
        if (nStrike > 0) {
            System.out.print(nStrike + "스트라이크");
        }
        System.out.println();
    }

    /**
     * 유저가 정답을 맞혔을 때 출력
     */
    public static void printCorrectAndGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /**
     * 게임 종료 시 유저의 선택을 입력받는다 (새게임 또는 게임종료)
     * @return 유저의 선택
     */
    public static String getUserChoiceForNextGame() {
        return scanner.nextLine();
    }
}
