package domain;

import jdk.jfr.Description;
import utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    @Description("플레이어가 겹치지 않는 3개의 숫자를 입력해 순서대로 배열에 저장")
    public static ArrayList<Integer> inputNumArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String nStr = scanner.next(); // 3자리 숫자 입력

        char[] charArray = nStr.toCharArray();
        ArrayList<Integer> userNumArray = new ArrayList<>();

        for (char c : charArray) {
            if (Utils.checkDuplicate(charArray, c) || charArray.length != 3) { // 중복인 경우 에러 발생시킴
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 프로그램을 종료합니다.");
            } else {
                userNumArray.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        return userNumArray;
    }
}
