package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListGenerator {

    private ListGenerator() {

    }

    public static List<Integer> getIntegerList(int predictNumber) {
        String number = Integer.toString(predictNumber);
        List<String> numberList = Arrays.asList(number.split(""));
        List<Integer> predictNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            predictNumberList.add(Integer.valueOf(numberList.get(i)));
        }
        return predictNumberList;
    }
}
