package model;

import java.util.List;

public class BaseballNumberGenerator {
    private List<Integer> number;
    private static int making_number_count = 3;

    public List<Integer> generate(){
        for(int i = 0; i < making_number_count; i++) {
            number.add((int) (Math.random() * 10));
        }
        return number;
    }
}
