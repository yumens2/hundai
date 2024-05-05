import jdk.jfr.Description;

import java.util.*;

public class main {

    public static void main(String[] args) {
        while (true) {
            // 1. 컴퓨터가 랜덤으로 서로 다른 값 3개를 골라 순서대로 배열에 저장
            ArrayList<Integer> randNumArray = makeRandNumArray();

            Boolean result = false;

            while (!result) {
                // 2. 사용자가 3개의 숫자 입력, 순서대로 배열에 저장
                ArrayList<Integer> userNumArray = makeUserNumArray();

                // 3. 게임 플레이어가 입력한 숫자에 대한 결과 판별
                result = showResult(userNumArray, randNumArray);
            }

            // 4. 게임 재시작 여부 선택
            int reStart = checkReStart();
            if (reStart == 2) {
                break;
            }
        }

    }

    //    @Description("게임 재시작 여부를 선택")
    private static int checkReStart() {
        System.out.println("Want to restart game? 1(Yes), 2(No)");
        Scanner scanner = new Scanner(System.in);
        int rst = scanner.nextInt();

        if (rst != 1 && rst != 2) {
            throw new IllegalArgumentException();
        } else {
            return rst;
        }
    }

    //    @Description("플레이어가 입력한 숫자에 대한 결과 판별")
    private static Boolean showResult(ArrayList<Integer> userNumArray,
        ArrayList<Integer> randNumArray) {
        int strike = 0;
        int ball = 0;
        // 1. 스트라이크 개수 계산
        strike = countStrike(userNumArray, randNumArray);
        // 2. 볼 개수 계산
        ball = countBall(userNumArray, randNumArray);
        // 3. 같은 수가 전혀 없으면 낫싱이란 힌트 제공
        if (strike == 0 && ball == 0) {
            System.out.println("nothing");
        }
        // 같은 수 있는 경우 결과 제시
        else {
            System.out.println(strike + " strike " + ball + " ball");
        }

        if (strike == 3) { // 올 스트라이크
            System.out.println("You have guessed all 3 numbers correctly! Game finish!");
            return true;
        } else { // 올 스트라이크가 아닌 경우
            return false;
        }
    }

    //    @Description("볼 개수 계산")
    private static int countBall(ArrayList<Integer> userNumArray, ArrayList<Integer> randNumArray) {
        int ballCnt = 0;
        for (int i = 0; i < userNumArray.size(); i++) {
            if (randNumArray.contains(userNumArray.get(i)) && !Objects.equals(randNumArray.get(i),
                userNumArray.get(i))) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

    //    @Description("스트라이크 개수 계산")
    private static int countStrike(ArrayList<Integer> userNumArray,
        ArrayList<Integer> randNumArray) {
        int strikeCnt = 0;
        for (int i = 0; i < userNumArray.size(); i++) {
            if (Objects.equals(userNumArray.get(i), randNumArray.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    //    @Description("플레이어가 겹치지 않는 3개의 숫자를 입력해 순서대로 배열에 저장")
    static ArrayList<Integer> makeUserNumArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter number: ");
        String nStr = scanner.next(); // 3자리 숫자 입력

        char[] charArray = nStr.toCharArray();
        ArrayList<Integer> userNumArray = new ArrayList<>();

        for (char c : charArray) {
            if (checkDuplicate(charArray, c) || charArray.length != 3) { // 중복인 경우 에러 발생시킴
                throw new IllegalArgumentException();
            } else {
                userNumArray.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        return userNumArray;
    }

    //    @Description("플레이어가 입력한 숫자(현 배열)에서 중복된 문자가 있는지 판별")
    private static boolean checkDuplicate(char[] charArray, char c) {
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


    //    @Description("컴퓨터가 랜덤으로 겹치지 않는 3개의 숫자를 뽑아 순서대로 배열에 저장")
    public static ArrayList<Integer> makeRandNumArray() {
        ArrayList<Integer> numArray = new ArrayList<>();
        while (numArray.size() < 3) {
            Random random = new Random();
            int n = random.nextInt(8) + 1; // 1~9 난수 생성

            if (!numArray.contains(n)) { // 배열에 없는 경우 숫자 추가
                numArray.add(n);
            }
        }
        System.out.println();
        return numArray;
    }
}