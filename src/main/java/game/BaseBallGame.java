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

}
