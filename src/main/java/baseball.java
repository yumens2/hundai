import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class baseball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] answer = generateRandomNumber(random); // 서로 다른 세 자리 수 생성
        System.out.println("게임을 시작합니다. 서로 다른 세 자리 수를 맞춰보세요.");

        while (true) {
            int[] guess = getUserGuess(scanner); // 사용자로부터 세 자리 수 입력 받기
            int[] result = compareGuess(answer, guess); // 입력한 숫자와 정답 비교

            if (result[0] == 3) { // 3스트라이크인 경우
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            printResult(result); // 현재 상태 출력
        }

        System.out.println("게임을 종료합니다.");
        scanner.close();
    }

    // 서로 다른 세 자리 수 생성
    private static int[] generateRandomNumber(Random random) {
        int[] number = new int[3];
        boolean[] used = new boolean[10];

        for (int i = 0; i < 3; i++) {
            int num;
            do {
                num = random.nextInt(10);
            } while (used[num] || (i == 0 && num == 0));
            number[i] = num;
            used[num] = true;
        }

        return number;
    }

    // 사용자로부터 세 자리 수 입력 받기
    private static int[] getUserGuess(Scanner scanner) {
        System.out.print("세 자리 숫자를 입력하세요: ");
        String input = scanner.nextLine();
        return Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
    }

    // 입력한 숫자와 정답 비교
    private static int[] compareGuess(int[] answer, int[] guess) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            if (answer[i] == guess[i]) { // 스트라이크인 경우
                strike++;
            } else { // 볼인 경우
                for (int j = 0; j < 3; j++) {
                    if (answer[i] == guess[j]) {
                        ball++;
                    }
                }
            }
        }

        return new int[]{strike, ball};
    }


    private static void printResult(int[] result) {
        int strike = result[0];
        int ball = result[1];

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.printf("%d스트라이크 %d볼\n", strike, ball);
        }
    }
}