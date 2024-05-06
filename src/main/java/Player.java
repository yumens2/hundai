import java.util.Scanner;

public class Player {
    public static void playBaseballGame(String answer) {
        Scanner sc = new Scanner(System.in);

        // 볼 확인을 위한 배열 생성
        int[] vis = new int[10];
        char[] answerArray = answer.toCharArray();
        for (char c : answerArray) {
            vis[c - '0'] = 1;
        }

        while (true) {
            // 사용자 입력 받기
            System.out.print("숫자를 입력해 주세요: ");
            String number = sc.nextLine();

            // 입력값 검증
            if (number.length() != 3 || !number.matches("^\\d+$")) {
                sc.close();  // 스캐너 자원 정리
                throw new IllegalArgumentException("올바르지 않은 입력입니다. 게임을 종료합니다.");
            }

            char[] numberArray = number.toCharArray();

            // 점수 계산 (스트라이크, 볼)
            int[] score = Computer.checkScore(answerArray, numberArray, vis);
            int strike = score[0];
            int ball = score[1];

            // 스트라이크, 볼 결과 출력
            if (ball > 0 && strike > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (ball > 0) {
                System.out.println(ball + "볼");
            } else if (strike > 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println("낫싱");
            }

            if (strike == 3) {
                return;
            }
        }
    }
}