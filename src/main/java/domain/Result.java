package domain;

import java.util.List;

public class Result {
    private int strike;
    private int ball;

    public void calculate(String input, List<Integer> number){
        this.strike = 0;
        this.ball = 0;

        for(int i = 0; i < 3; i++){
            int currentNum = input.charAt(i) - '0';

            if(currentNum == number.get(i)){
                this.strike++;
                continue;
            }

            if(number.contains(currentNum)){
                this.ball++;
            }
        }
    }

    private boolean isNothing(){
        return this.strike == 0 && this.ball == 0;
    }
}
