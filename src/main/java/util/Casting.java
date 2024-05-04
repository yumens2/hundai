package util;

import java.util.ArrayList;
import java.util.List;

public class Casting {
    public static List<Integer> stringToIntegerList(String number) {
        List<Integer> list = new ArrayList<>();
        for(char c : number.toCharArray()) {
            list.add(c - '0');
        }
        return list;
    }
}