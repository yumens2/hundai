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
}