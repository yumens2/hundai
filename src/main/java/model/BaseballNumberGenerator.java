package model;

/**
 * 컴퓨터 측의 랜덤 숫자 생성
 */
public class BaseballNumberGenerator {

    public String generateBaseballNumberString(int size) {
        if (size <= 0) {
            return "";
        }

        int idx = 0;
        String numberString = "";
        boolean[] numberCheck = new boolean[10];

        while (idx < size) {
            int number = (int) (Math.random() * 10);
            if (number == 0) {
                number = 1;
            }

            if (numberCheck[number]) {
                continue;
            }

            numberString += Integer.toString(number);
            numberCheck[number] = true;
            idx++;
        }

        return numberString;
    }
}