package com.mini.numbaseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameModel {

    private int answer;
    private boolean isCorrect = false;

    public void initAnswer() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        this.answer = 0;
        for (int i = 0; i < 3; i++) {
            this.answer = this.answer * 10 + numbers.get(i);
        }
    }

    public int countStrike(int number1, int number2) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (number1 % 10 == number2 % 10) {
                cnt++;
            }
            number1 /= 10;
            number2 /= 10;
        }

        return cnt;
    }

    public int countBall(int number1, int number2) {
        int cnt = 0;
        int tempNumber2 = number2;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(tempNumber2 % 10);
            tempNumber2 /= 10;
        }

        for (int i = 0; i < 3; i++) {
            if (set.contains(number1 % 10) && (number1 % 10 != number2 % 10)) {
                cnt++;
            }
            number1 /= 10;
            number2 /= 10;
        }

        return cnt;
    }

    public String createResult(int number1, int number2) {
        StringBuilder stringBuilder = new StringBuilder();
        int strike = countStrike(number1, number2);
        int ball = countBall(number1, number2);

        if (ball > 0) {
            stringBuilder.append(ball).append("볼 ");
        }

        if (strike > 0) {
            stringBuilder.append(strike).append("스트라이크 ");
            if(strike==3){
                isCorrect = true;
            }
        }

        if (stringBuilder.isEmpty()) {
            stringBuilder.append("낫싱");
        }

        return stringBuilder.toString().strip();
    }

    public int getAnswer() {
        return answer;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }
}
