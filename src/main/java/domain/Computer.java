package domain;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Random;

public class Computer {

    @Description("컴퓨터가 랜덤으로 겹치지 않는 3개의 숫자를 뽑아 순서대로 배열에 저장")
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
