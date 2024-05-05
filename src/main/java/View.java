import java.util.Scanner;

public class View {

    private View() {}

    public static int guessView() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        return num;
    }

    public static void hintView(ResultDto resultDto) {
        int strike = resultDto.getStrike();
        int ball = resultDto.getBall();

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static int successView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        return num;
    }

}
