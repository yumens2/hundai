import java.util.Scanner;

public class IO {

    private static Scanner scanner = new Scanner(System.in);

    public static String in() {
        return scanner.nextLine();
    }

    public static void outProgress() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void outResult(int ball, int strike) {
        if (ball != 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike != 0) {
            System.out.printf("%d스트라이크", strike);
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }

    public static void outEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
