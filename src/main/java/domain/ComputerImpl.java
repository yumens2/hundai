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

}
