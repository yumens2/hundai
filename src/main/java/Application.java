import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            int answer = Random.getRandomNumber();
            int input;
            try {
                input = getValidInput(sc);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.close();
                return;  // 잘못된 입력 시 예외 메시지 출력 후 프로그램 종료!
            }

            int Strikes = Logic.judgment_strike(answer, input);
            int Balls = Logic.judgment_ball(answer, input);

            printResults(Strikes, Balls);

            if (Strikes == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                if (!askForContinuation(sc)) {
                    break;
                }
            }
        }

        sc.close();
    }

    private static int getValidInput(Scanner sc) throws IllegalArgumentException {
        System.out.printf("숫자를 입력해 주세요 : ");
        int input = sc.nextInt();
        
        int hundreds = input / 100;
        int tens = (input % 100) / 10;
        int ones = input % 10;

        if (hundreds < 1 || hundreds > 9 || tens < 1 || tens > 9 || ones < 1 || ones > 9) {
            throw new IllegalArgumentException("각 자리수는 1부터 9까지의 숫자여야 합니다!");
        }
        return input;
    }

    private static void printResults(int Strikes, int Balls) {
        if (Strikes == 0 && Balls == 0) {
            System.out.println("낫싱");
        } else if (Strikes == 0) {
            System.out.println(Balls + "볼");
        } else if (Balls == 0) {
            System.out.println(Strikes + "스트라이크");
        } else {
            System.out.println(Balls + "볼 " + Strikes + "스트라이크");
        }
    }

    private static boolean askForContinuation(Scanner sc) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = sc.nextInt();
        if(input == 1) {
            return true;
        }
        else if (input == 2) {
            return false;
        }
        else {
            return false;
        }
    }
}
