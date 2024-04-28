package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberService {
    private RandomNumberService() {

    }

    static public List<Integer> getThreeUniqueNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = getRandomNumber();
            if(isDuplicate(randomNumbers,randomNumber)) continue;
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    static private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;//bound check!
    }

    static private boolean isDuplicate(List<Integer> numberList, int number) {
        return numberList.contains(number);
    }
}
