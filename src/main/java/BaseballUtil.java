public class BaseballUtil {

    public int strike(int randomNumber, int inputNumber) {
        int cnt = 0;
        String randomStr = Integer.toString(randomNumber);
        String inputStr = Integer.toString(inputNumber);

        for (int i = 0; i < 3; i++) {
            if (randomStr.charAt(i) == inputStr.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int ball(int randomNumber, int inputNumber) {
        int cnt = 0;
        String randomStr = Integer.toString(randomNumber);
        String inputStr = Integer.toString(inputNumber);

        for (int i = 0; i < 3; i++) {
            char n = inputStr.charAt(i);
            if (randomStr.contains(Character.toString(n))
                    && randomStr.charAt(i) != n) {
                cnt++;
            }
        }
        return cnt;
    }
}