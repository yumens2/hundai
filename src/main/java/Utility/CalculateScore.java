package Utility;

public class CalculateScore {
    private CalculateScore(){}

    public static int ballCount(String answer, String inputNumber){
        int ball = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                if(i == j) continue;
                if(answer.charAt(i) == inputNumber.charAt(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }
    public static int strikeCount(String answer, String inputNumber){
        int strike = 0;
        for(int i = 0; i < 3; i++){
            if(answer.charAt(i) == inputNumber.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

}
