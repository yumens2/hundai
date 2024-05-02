package baseball.domain;

import baseball.utils.GenerateRandomNumber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Computer {

    private List<Integer> computerNumbers;
    private GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();

    public void setComputerNumber() {
        computerNumbers = generateRandomNumber.generate();
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }


}
