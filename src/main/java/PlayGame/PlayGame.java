package PlayGame;

import static GenerateRandomNumber.RandomNumberGeneratorConfigure.LENGTH;
import static GenerateRandomNumber.RandomNumberGeneratorConfigure.validationConfigure;

import CompareNumber.CompareNumber;
import GenerateRandomNumber.RandomNumberGenerator;
import UserInput.UserPredictNumber;
import java.util.List;

public class PlayGame {

    // 게임을 시작하는 메서드
    public static void start() {
        if (!validationConfigure()) {
            throw new IllegalArgumentException("RandomNumberGeneratorConfigure is not valid");
        }
        while (true) {
            List<Integer> generatedNumbers = RandomNumberGenerator.generateRandomNumber();
            // for(int i:generatedNumbers) System.out.println(i);
            if (!getInput(generatedNumbers)) {
                break;
            }
        }
    }

    // 사용자의 입력을 받고 검증하는 메서드
    private static boolean getInput(List<Integer> generatedNumbers) {
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            List<Integer> input = UserPredictNumber.predictInput();

            int strike = CompareNumber.strike(generatedNumbers, input);
            int ball = CompareNumber.ball(generatedNumbers, input);

            if (!result(strike, ball)) {
                break;
            }
        }
        return checkResult();
    }

    // 스트라이크와 볼을 입력받고, 그에 해당하는 결과 출력
    private static boolean result(int strike, int ball) {
        if (strike == LENGTH.getValue()) {
            System.out.println(LENGTH.getValue() + "스트라이크");
            return false;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return true;
    }

    // 결과를 확인하고 게임을 재시작할지 종료할지 결정
    private static boolean checkResult() {
        System.out.println(LENGTH.getValue() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int restartInput = UserInput.RestartInput.restartInput();
        if (restartInput == 1) {
            return true;
        } else if (restartInput == 2) {
            return false;
        }
        return false;
    }
}
