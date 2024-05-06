public class Check {
    public static boolean checkAnswer(int[] numArr, int[] inputArr) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < numArr.length; i++) {
            for (int j = 0; j < inputArr.length; j++) {
                if (numArr[i] == inputArr[j] && i == j) {
                    strike++;
                } else if (numArr[i] == inputArr[j] && i != j) {
                    ball++;
                }
            }
        }

        if (strike == 3) {
            System.out.println("정답!");
            return true;
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
            return false;
        }
    }
}
