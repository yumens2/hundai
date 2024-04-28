package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseballGame {

    private int[] computerThreeNum;

    public BaseballGame() {
        computerThreeNum = new int[3];
        setRandomThreeNum(computerThreeNum);
    }

    public void playBaseballGame() {
        boolean endGame = false;
        Scanner input = new Scanner(System.in);

        while (!endGame) {

            int[] userThreeNum = new int[3];
            Map<String, Integer> stkAndBall = new HashMap<>();

            stkAndBall.put("스트라이크", 0);
            stkAndBall.put("볼", 0);
            System.out.println("랜덤 수" + Arrays.toString(computerThreeNum));

            System.out.print("숫자를 입력해 주세요 : ");

            try {
                String s = input.next();

                if (isIllegalArgument(s)) {
                    throw new IllegalArgumentException();
                }

                userThreeNum[0] = Integer.parseInt(String.valueOf(s.charAt(0)));

                for (int index = 1; index < 3; index++) {
                    int usersIthInt = Integer.parseInt(String.valueOf(s.charAt(index)));

                    if (haveSameElement(userThreeNum, usersIthInt, index)) {
                        throw new IllegalArgumentException();
                    } else {
                        userThreeNum[index] = usersIthInt;
                    }
                }

                countStkAndball(stkAndBall, computerThreeNum, userThreeNum);

                if (stkAndBall.get("스트라이크") == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    int i = input.nextInt();
                    input.nextLine();

                    if (i < 1 || i > 2) {
                        throw new IllegalArgumentException();
                    }
                    if (i == 1) {
                        setRandomThreeNum(computerThreeNum);
                    } else {
                        endGame = true;
                    }

                } else {
                    printSBmap(stkAndBall);
                }

            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 수를 입력하였습니다.");
                break;
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


    private void countStkAndball(Map<String, Integer> map, int[] computerThreeNum,
            int[] userThreeNum) {
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
            if (str.length() != 3) {
                return true;
            }

            for (int i = 0; i < 3; i++) {
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
            if (!haveSameElement(threeNum, randomInt, index)) { //같은 원소가 없을 때 할당
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
