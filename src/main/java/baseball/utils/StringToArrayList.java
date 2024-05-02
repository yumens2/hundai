package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class StringToArrayList {

    public static List<Integer> parse(String input){
        List<Integer> parsedList = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            parsedList.add(Integer.valueOf(String.valueOf(input.charAt(i))));
        }

        return parsedList;
    }

}
