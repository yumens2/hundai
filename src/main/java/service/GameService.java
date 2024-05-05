package service;

import static utils.ValidationUtil.isThreeDigits;

import error.ErrorMessage;
import java.util.Scanner;
import utils.RandomUtil;

public class GameService {

    private final JudgeService judgeService = new JudgeService();
    private int[] answer = RandomUtil.getRandomNumbers();

    public void startGame() {
        boolean isRunning = true;

        while (isRunning) {
            int[] numbers = inputThreeDigits();

            if (judgeService.checkAnswer(numbers, answer)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isRunning = askForRestart();
            }
        }
    }

    /**
     * 사용자로부터 세 자리의 수를 입력 받음
     *
     * @return 세 자리 수
     */
    public int[] inputThreeDigits() {
        int num;

        try {
            System.out.print("숫자를 입력해 주세요 : ");
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_ONLY);
        }

        isThreeDigits(num);
        return intToArrayInt(num);
    }

    /**
     * 정수를 배열로 변환
     *
     * @param num 세 자리 정수
     * @return 각 자리 수를 요소로 담은 배열 (123 -> [1, 2, 3])
     */
    public int[] intToArrayInt(int num) {
        int[] numbers = new int[3];
        int i = 2;

        while (num > 0) {
            numbers[i] = num % 10;
            num /= 10;
            i -= 1;
        }

        return numbers;
    }

    /**
     * 게임을 종료할 건지 선택. 다시 시작한다면 answer 초기화
     *
     * @return 게임 종료 선택 시 true, 아니면 false
     */
    public boolean askForRestart() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            if (n == 1) {
                answer = RandomUtil.getRandomNumbers();
                return true;
            } else if (n == 2) {
                return false;
            } else {
                System.out.println("1 또는 2만 입력할 수 있습니다.");
            }
        }
    }

}
