package Utility;

public class CalculateScore {
    private CalculateScore(){}
    //depth 줄이기
    public static int ballCount(String answer, String inputNumber){
        int ball = 0;
        if(inputNumber.charAt(0) == answer.charAt(1) || inputNumber.charAt(0) == answer.charAt(2)) ball++;
        if(inputNumber.charAt(1) == answer.charAt(0) || inputNumber.charAt(1) == answer.charAt(2)) ball++;
        if(inputNumber.charAt(2) == answer.charAt(0) || inputNumber.charAt(2) == answer.charAt(1)) ball++;
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
