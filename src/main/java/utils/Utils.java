package utils;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Utils {

    @Description("플레이어가 입력한 숫자(현 배열)에서 중복된 문자가 있는지 판별")
    public static boolean checkDuplicate(char[] charArray, char c) {
        int cnt = 0;
        for (char c1 : charArray) {
            if (c1 == c) {
                cnt++;
            }
        }
        if (cnt > 1) {
            return true;
        } else {
            return false;
        }
    }

    @Description("플레이어가 입력한 숫자에 대한 결과 판별")
    public static Boolean showResult(ArrayList<Integer> userNumArray,
                                     ArrayList<Integer> randNumArray) {
        int strike = 0;
        int ball = 0;
        // 1. 스트라이크 개수 계산
        strike = Utils.countStrike(userNumArray, randNumArray);
        // 2. 볼 개수 계산
        ball = Utils.countBall(userNumArray, randNumArray);
        // 3. 같은 수가 전혀 없으면 낫싱이란 힌트 제공
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        // 같은 수 있는 경우 결과 제시
        else {
            System.out.println(ball + " 볼 " + strike + " 스트라이크");
        }

        if (strike == 3) { // 올 스트라이크
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else { // 올 스트라이크가 아닌 경우
            return false;
        }
    }

    @Description("볼 개수 계산")
    public static int countBall(ArrayList<Integer> userNumArray, ArrayList<Integer> randNumArray) {
        int ballCnt = 0;
        for (int i = 0; i < userNumArray.size(); i++) {
            if (randNumArray.contains(userNumArray.get(i)) && !Objects.equals(randNumArray.get(i),
                    userNumArray.get(i))) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

    @Description("스트라이크 개수 계산")
    public static int countStrike(ArrayList<Integer> userNumArray,
                                  ArrayList<Integer> randNumArray) {
        int strikeCnt = 0;
        for (int i = 0; i < userNumArray.size(); i++) {
            if (Objects.equals(userNumArray.get(i), randNumArray.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    @Description("게임 재시작 여부를 선택")
    public static int checkReStart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int rst = scanner.nextInt();

        if (rst != 1 && rst != 2) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 프로그램을 종료합니다.");
        } else {
            return rst;
        }
    }
}
