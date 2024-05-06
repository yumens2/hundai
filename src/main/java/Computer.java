import java.util.Random;

public class Computer {
    // 난수 생성 메서드
    public static String makeRandomNumber() {
        String answer = "";
        int[] vis = new int[10];  // 중복 확인 배열
        Random random = new Random();
        int cnt = 0;

        while (cnt < 3) {
            int ranNum = random.nextInt(9) + 1;
            if (vis[ranNum] == 0) {
                vis[ranNum] = 1;
                answer += Integer.toString(ranNum);
                cnt++;
            }
        }
        return answer;
    }

    // 점수 계산 메서드
    public static int[] checkScore(char[] answerArray, char[] numberArray, int[] vis) {
        int[] score = new int[2];
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (answerArray[i] == numberArray[i]) {
                strike++;
                continue;
            }
            if (vis[numberArray[i] - '0'] == 1) {
                ball++;
            }
        }

        score[0] = strike;
        score[1] = ball;

        return score;
    }
}