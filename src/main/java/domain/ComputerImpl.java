package domain;

import java.util.ArrayList;
import java.util.List;

public class ComputerImpl implements Computer{
    @Override
    public List<Integer> generateRandomNumbers() {
        List<Integer> generatedNumbers = new ArrayList<>();

        while (generatedNumbers.size() < 3) {
            int randomNumber = (int)(Math.random()*9) + 1;
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }
        return generatedNumbers;
    }

    @Override
    public String checkStrike(List<Integer> generatedNumbers, String userInputs) {
        int strike = 0;
        int ball = 0;

        char[] userInputChar = userInputs.toCharArray();
        for (int i = 0; i < generatedNumbers.size(); i++) {
            int userNumber = userInputChar[i] - '0';
            if (generatedNumbers.contains(userNumber)) {
                strike += isStrike(generatedNumbers.get(i), userNumber);
                ball   += isBall(generatedNumbers.get(i), userNumber);
            }
        }
        return answerTemplate(strike, ball);
    }

    private int isStrike(int generatedNumber, int userNumber) {
            if (generatedNumber == userNumber) {
                return 1;
            }
            return 0;
    }

    private int isBall(int generatedNumber, int userNumber) {
        if (generatedNumber != userNumber) {
            return 1;
        }
        return 0;
    }


    private String answerTemplate(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
