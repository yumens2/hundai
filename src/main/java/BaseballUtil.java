public class BaseballUtil {

    public int strike(String randomNumber, String inputNumber) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumber.charAt(i) == inputNumber.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    public int ball(String randomNumber, String inputNumber) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            char n = inputNumber.charAt(i);
            if (randomNumber.contains(Character.toString(n))
                    && randomNumber.charAt(i) != n) {
                cnt++;
            }
        }
        
        return cnt;
    }
}