package service;

public class JudgeService {

    /**
     * 정답을 모두 맞혔는지 판단 (다 맞추지 못했으면 힌트 제공)
     *
     * @param numbers 사용자가 입력한 세 자리 수
     * @param answer  컴퓨터가 생성한 세 자리 수
     * @return 맞혔으면(= 종료) true, 아니면 false
     */
    public boolean checkAnswer(int[] numbers, int[] answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (answer[i] == numbers[i]) {
                strike++;
            } else if (containsDigit(numbers[i], answer)) {
                ball++;
            }
        }

        if (strike == 3) {
            return true;
        } else {
            printHint(strike, ball);
            return false;
        }
    }

    /**
     * 배열에서 특정 숫자가 포함되어 있는지 확인
     *
     * @param num    정수
     * @param answer 정답 배열
     * @return 포함 여부
     */
    private boolean containsDigit(int num, int[] answer) {
        for (int n : answer) {
            if (n == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 힌트를 출력
     *
     * @param strike 스트라이크 수
     * @param ball   볼 수
     */
    private void printHint(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

}
