import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Logic logic = new Logic();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            int userNumber = Utils.InputToRightInteger(sc.nextLine());
            int strike = logic.isStrike(userNumber);
            int ball = logic.isBall(userNumber);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
    }
}