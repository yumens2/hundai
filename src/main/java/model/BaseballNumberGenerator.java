package model;

import java.util.ArrayList;

public class BaseballNumberGenerator {
    public static final int making_number_count = 3;

    public ArrayList<Integer> generate(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while(numbers.size() < making_number_count){
            int number = (int) (Math.random() * 9)+1;
            if(!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}
