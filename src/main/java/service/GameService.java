package service;

import static utils.ValidationUtil.isThreeDigits;

import error.ErrorMessage;
import java.util.Scanner;
import model.Game;
import utils.RandomUtil;

public class GameService {

    public void startGame() {
        Game game = new Game(RandomUtil.getRandomNumbers());
        int[] numbers = inputThreeDigits();
    }

    /**
     * 사용자로부터 세 자리의 수를 입력 받음
     *
     * @return 세 자리 수
     */
    private int[] inputThreeDigits() {
        Scanner sc = new Scanner(System.in);
        int num = 9999;

        try {
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
    private int[] intToArrayInt(int num) {
        int[] numbers = new int[3];
        int i = 0;

        while (num > 0) {
            numbers[i] = num % 10;
            num /= 10;
            i += 1;
        }

        return numbers;
    }

}
