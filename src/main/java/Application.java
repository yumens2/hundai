import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("welcome to number baseball game!");
        Logic logic = new Logic();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("숫자를 입력해 주세요:");
            int userNumber = sc.nextInt();
            // todo: check if userNumber is valid
            int strike = logic.isStrike(userNumber);
            int ball = logic.isBall(userNumber);
        }
    }
}