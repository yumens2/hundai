package view;

import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    private View() {

    }

    public static String getUserGuess() {
        String strUserInput;
        System.out.print("숫자를 입력하세요 : ");
        strUserInput = scanner.nextLine();
        return strUserInput;
    }

    public static void printResult(int nBall, int nStrike) {
        if (nBall == 0 && nStrike == 0) {
            System.out.println("낫싱");
        } else {
            if (nBall > 0) {
                System.out.print(nBall + "볼");
            }
            if (nStrike > 0) {
                System.out.print(nStrike + "스트라이크");
            }
            System.out.println();
        }
    }
}
