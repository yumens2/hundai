package precourse.utils;

import java.util.*;

public class DigitUtil {
    public static String createUniqueDigits(int length){
        if (!isOneDigitOfPositive(length)) throw new IllegalArgumentException();

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

    public static boolean isDigitsOfPositive(String str){
        if (str.isEmpty()) return false;

        boolean isNotZero = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') return false;
            if (c != '0') isNotZero = true;
        }
        return isNotZero;
    }

    public static boolean isOneDigitOfPositive(int num){
        return (num > 0 && num < 10);
    }

    private DigitUtil(){}
}

