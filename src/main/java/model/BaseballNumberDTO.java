package model;

import java.util.List;

public class BaseballNumberDTO {
    private List<Integer> number;
    private static int making_number_count = 3;

    public BaseballNumberDTO(){
        for(int i = 0; i < making_number_count; i++) {
            number.add((int) (Math.random() * 10));
        }
    }
}
