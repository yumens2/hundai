package game;

public class BaseBallGame {

    public int checkStrike(String computerNumber, String userNumber){
        int strike = 0;

        for(int i=0; i<3; i++){
            if(computerNumber.charAt(i) == userNumber.charAt(i)){
                strike++;
            }
        }

        return strike;
    }

    public int checkBall(String computerNumber, String userNumber){
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && computerNumber.charAt(i) == userNumber.charAt(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }

}
