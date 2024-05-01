package utils;

/**
 * 난수를 생성하는 클래스
 */
public class RandomNumberGenerator {

    /**
     * 1~9 사이의 서로 다른 세 자리 수를 생성한다.
     *
     * @return 1~9 사이의 서로 다른 세 자리로 이루어진 정수
     */
    public static String generateRandomNumber() {
        int num = 0;
        String numStr = "";

        for(int i = 0; i < 3; i++) {
            num = pickNumber();
            if(numStr.contains(String.valueOf(num))) {
                i--;
                continue;
            }
            numStr += String.valueOf(num);
        }

        return numStr;
    }

    /**
     * 1~9 사이의 난수를 생성한다.
     *
     * @return 1~9 사이의 난수
     */
    private static Integer pickNumber() {
        return Integer.valueOf((int) (Math.random() * 9) + 1);
    }
}
