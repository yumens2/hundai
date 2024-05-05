package model;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 사용자로부터 입력을 받으면서 본격적으로 게임을 진행 userActing : 사용자로부터 입력 받으면서 정답을 맞출 때까지 게임 진행 사용자에게 게임 재시작, 종료 여부를
 * 입력받아 그에 맞게 수행
 */
public class GamePlayer {

    public void userActing(int genarateBaseballNumberSize, AnalyseBaseballNumber analyzer) {
        boolean isDone;
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String userNumberString = scan.nextLine();

            Set<String> set = new HashSet<String>();

            try {
                Integer.parseInt(userNumberString);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 프로그램을 종료합니다.");
            }

            if (userNumberString.length() != genarateBaseballNumberSize) {
                throw new IllegalArgumentException("입력된 숫자의 자릿수가 잘못되었습니다. 프로그램을 종료합니다.");
            }

            for (int i = 0; i < genarateBaseballNumberSize; i++) {
                set.add(userNumberString.substring(i, i + 1));
            }

            if (set.size() != genarateBaseballNumberSize) {
                throw new IllegalArgumentException("중복된 숫자가 존재합니다. 프로그램을 종료합니다.");
            }

            System.out.println(analyzer.getResponse(userNumberString));
            isDone = analyzer.getIsDone();

            if (isDone) {
                break;
            }
        }
    }

    public boolean gameRestart() {
        Scanner scan = new Scanner(System.in);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userRestart = scan.nextLine();
        int userRestartNumber;

        try {
            userRestartNumber = Integer.parseInt(userRestart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 프로그램을 종료합니다.");
        }

        if (userRestartNumber != 1 && userRestartNumber != 2) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 프로그램을 종료합니다.");
        }

        if (userRestartNumber == 1) {
            return true;
        } else {
            System.out.println("게임을 종료합니다.");
            return false;
        }
    }
}
