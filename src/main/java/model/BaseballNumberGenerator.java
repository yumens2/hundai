package model;

import java.util.ArrayList;

public class BaseballNumberGenerator {
    public static final int making_number_count = 3;

    public ArrayList<Integer> generate(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for(int i = 0; i < making_number_count; i++) {
            number.add((int) (Math.random() * 9)+1);
        }
        return number;
    }
}
