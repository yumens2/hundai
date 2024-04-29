package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseballGame {

    private int[] computerThreeNum; //1~9까지 랜덤으로 저장할 크기가 3일 배열

    public BaseballGame() {
        computerThreeNum = new int[3];
        setRandomThreeNum(computerThreeNum);
    }

    public void playBaseballGame() {
        boolean endGame = false; //게임을 끝낼때 true로 바뀜
        Scanner input = new Scanner(System.in); //유저가 입력하는 수

        while (!endGame) {

            int[] userThreeNum = new int[3]; //유저가 입력한 수를 저장할 배열
            Map<String, Integer> stkAndBall = new HashMap<>(); //strike와 ball count를 저장할 map

            stkAndBall.put("스트라이크", 0);
            stkAndBall.put("볼", 0);
            System.out.print("숫자를 입력해 주세요 : ");

            try {
                String s = input.next();

                if (isIllegalArgument(s)) { //잘못된 수를 입력할 경우
                    throw new IllegalArgumentException(); //예외 던지기
                }

                inputToInt(userThreeNum, s); //인풋을 하나씩 잘라서 각각을 int 배열로 변경
                countStkAndBall(stkAndBall, computerThreeNum, userThreeNum); //컴퓨터의 랜덤 수, 유저의 수를 비교해서 스트라이크, 볼 개수를 기록함

                if (stkAndBall.get("스트라이크") == 3) { //3 스트라이크 라면
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    int i = input.nextInt();
                    input.nextLine();

                    if (i < 1 || i > 2) { //유저가 올바른 수를 입력했는지 판별
                        throw new IllegalArgumentException();
                    }
                    if (i == 1) { //1이면 새로 시작하기 위해 랜덤으로 다시 뽑음
                        setRandomThreeNum(computerThreeNum);
                    } else { // 2면 끝내기
                        endGame = true;
                    }

                } else { // 3스트라이크가 아니라면
                    printSBmap(stkAndBall); //몇 볼, 몇 스트라이크 인지 출력
                }

            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 수를 입력하였습니다.");
                break;
            }


        }

    }

    private void inputToInt(int[] userThreeNum, String s) {
        userThreeNum[0] = Integer.parseInt(String.valueOf(s.charAt(0)));

        for (int index = 1; index < 3; index++) {
            int usersIthInt = Integer.parseInt(String.valueOf(s.charAt(index)));

            if (haveSameElement(userThreeNum, usersIthInt, index)) { //인풋은 서로 다른수여야 함
                throw new IllegalArgumentException();
            } else {
                userThreeNum[index] = usersIthInt;
            }
        }
    }

    private void printSBmap(Map<String, Integer> map) {
        if (map.get("스트라이크") == 0) {
            if (map.get("볼") == 0) {
                System.out.println("낫싱");
            } else {
                System.out.println(map.get("볼") + "볼");
            }
        } else {
            if (map.get("볼") == 0) {
                System.out.println(map.get("스트라이크") + "스트라이크");
            } else {
                System.out.println(map.get("볼") + "볼 " + map.get("스트라이크") + "스트라이크");
            }
        }
    }


    private void countStkAndBall(Map<String, Integer> map, int[] computerThreeNum, int[] userThreeNum) {
        for (int userIdx = 0; userIdx < 3; userIdx++) {
            for (int comIdx = 0; comIdx < 3; comIdx++) {
                if (userThreeNum[userIdx] == computerThreeNum[comIdx]) {
                    if (userIdx == comIdx) {
                        map.replace("스트라이크", map.get("스트라이크") + 1);
                    } else {
                        map.replace("볼", map.get("볼") + 1);
                    }
                }
            }
        }
    }


    private boolean isIllegalArgument(String str) {
        try {
            if (str.length() != 3) { //인풋의 길이는 3이여야 함
                return true;
            }

            for (int i = 0; i < 3; i++) { //각각의 숫자는 1~9까지여야 함
                if (str.charAt(i) < '1' || str.charAt(i) > '9') {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }


    private void setRandomThreeNum(int[] threeNum) {
        threeNum[0] = (int) (Math.random() * 9 + 1);
        for (int index = 1; index < 3; ) {
            int randomInt = (int) (Math.random() * 9 + 1);
            if (!haveSameElement(threeNum, randomInt, index)) { // 랜덤 수는 서로 다른수여야 함
                threeNum[index] = randomInt;
                index++;
            }
        }
    }

    private boolean haveSameElement(int[] threeNum, int Num, int index) {
        for (int i = 0; i < index; i++) {
            if (threeNum[i] == Num) {
                return true;
            }
        }
        return false;
    }
}
