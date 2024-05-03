package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private List<Integer> number;

    public void generateRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            int randomNumber = (int)(Math.random() * 9) + 1;
            numbers.add(randomNumber);
        }
         this.number = new ArrayList<>(numbers);
    }

    public List<Integer> getNumber() {
        return number;
    }
}
