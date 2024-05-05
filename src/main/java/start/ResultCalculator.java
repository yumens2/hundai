package start;

public class ResultCalculator {
    public static String calculateResult(int[] compArr, String usrInput) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < compArr.length; ++i) {
            int usrNum = usrInput.charAt(i) - '0';
            if(compArr[i] == usrNum) strike++;
            else if(usrInput.contains(String.valueOf(compArr[i]))) {
                ball++;
            }
        }

        if(strike == 3) {
            return "3스트라이크";
        }
        else if(strike == 0) {
            if(ball == 0) {
                return "낫싱";
            } else {
                return ball + "볼";
            }
        }
        else {
            if(ball == 0) {
                return strike + "스트라이크";
            } else {
                return ball + "볼 " + strike + "스트라이크";
            }
        }
    }
}
