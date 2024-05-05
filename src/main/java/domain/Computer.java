package domain;

import java.util.Random;

import util.Constants;

public class Computer {
  private final BaseballNumber comNum;
  private final Random random;

    public Computer() {
        this.comNum = new BaseballNumber();
        this.random = new Random();
    }

    public void generateRandomNumber() {
        String randomNum = "";
        while (randomNum.length() < Constants.NUMBER_LENGTH) {
            int randomNumber = random.nextInt(9) + 1;
            String randomString = String.valueOf(randomNumber);
            if (!randomNum.contains(randomString)) {
              randomNum += randomString;
            }
        }
        comNum.setNumber(randomNum);
        System.out.println("random = " + randomNum);
    }

    public BaseballNumber getComputerNumber() {
        return comNum;
    }
}
