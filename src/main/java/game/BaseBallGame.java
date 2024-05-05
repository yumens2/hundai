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

    public void printGameInfo(int strike, int ball){
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if(strike > 0 && ball == 0) {
            System.out.println(strike+"스트라이크");
        } else if(strike == 0 && ball > 0){
            System.out.println(ball+"볼");
        }
        else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

}
