package com.mini.numbaseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameModel {

    private int answer;

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

    public int countStrike(int input) {
        int cnt = 0;
        int tempAnswer = this.answer;

        for (int i = 0; i < 3; i++) {
            if (input % 10 == tempAnswer % 10) {
                cnt++;
            }
            input /= 10;
            tempAnswer /= 10;
        }

        return cnt;
    }

    public int getAnswer() {
        return answer;
    }
}
