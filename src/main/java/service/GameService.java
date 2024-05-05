package service;

import java.util.*;

public class GameService {

    private String secretNumber;
    public GameService() {
        generateSecretNumber();
    }
    public void setSecretNumber(String number) {
        this.secretNumber = number;
    }
    public void generateSecretNumber() {
        Random random = new Random();
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 3) {
            int number = 1 + random.nextInt(9); // 1부터 9까지의 랜덤 숫자 생성
            numbers.add(number);
        }

        StringBuilder secretBuilder = new StringBuilder();
        for (int number : numbers) {
            secretBuilder.append(number);
        }
        this.secretNumber = secretBuilder.toString();
    }

    public String checkGuess(String guess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++){
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                strikes++;
            }
            else if (secretNumber.indexOf(guess.charAt(i)) != -1) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        if (strikes == 0) {
            return balls + "볼";
        }
        else if (balls == 0) {
            return strikes + "스트라이크";
        }
        else {
            return balls + "볼 " + strikes + "스트라이크";
        }

    }
}
