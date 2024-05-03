package precourse.utils;

import java.util.*;

public class DigitUtil {
    public static String createUniqueDigits(int length){
        if (length > 10) throw new IllegalArgumentException();

        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(digits.get(i));
        }

        return sb.toString();
    }

    private DigitUtil(){}
}

