package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    private final ComputerNumber computerNumber;

    public Computer(final int capacity, final List<Integer> computerValues){
        this.computerNumber = new ComputerNumber(capacity, computerValues);
    }

    public int getCapacity(){
        return computerNumber.capacity;
    }
    public int countStrike(List<Integer> humanValues){
        validateHumanValues(humanValues);
        List<Integer> computerValues = computerNumber.values;
        int strike = 0;
        for(int index = 0; index < computerNumber.capacity; index++){
            if(computerValues.get(index).equals(humanValues.get(index))){
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> humanValues){
        validateHumanValues(humanValues);
        List<Integer> computerValues = computerNumber.values;
        int ball = 0;
        for(int computerIndex = 0; computerIndex < computerNumber.capacity; computerIndex++){
            int targetIndex = humanValues.indexOf(computerValues.get(computerIndex));
            if(targetIndex == -1 || targetIndex == computerIndex){
                continue;
            }
            ball++;
        }
        return ball;
    }

    private void validateHumanValues(List<Integer> humanValues){
        if(humanValues.size() != computerNumber.capacity){
            throw new IllegalArgumentException("숫자가 자릿수가 일치하지 않습니다.");
        }
    }

    private class ComputerNumber {
        private final int capacity;
        private final List<Integer> values;

        public ComputerNumber(final int capacity, final List<Integer> values) {
            if(capacity < 1 || capacity > 9){
                throw new IllegalArgumentException("랜덤값 자릿수는 1이상 9이하 입니다.");
            }
            if(values.size() != capacity){
                throw new IllegalArgumentException("컴퓨터의 랜덤값의 자리수와 주어진 자리수가 일치하지 않습니다.");
            }
            this.capacity = capacity;
            this.values = values;
        }
    }

}
