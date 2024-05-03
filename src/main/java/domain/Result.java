package domain;

import java.util.List;

import static constant.MessageConstants.*;

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

    public boolean isCorrect(){
        return this.strike == 3;
    }

    public void reset(){
        this.strike = 0;
        this.ball = 0;
    }

    private boolean isNothing(){
        return this.strike == 0 && this.ball == 0;
    }

    @Override
    public String toString() {
        if(isNothing()){
            return RESULT_NOTHING;
        }

        StringBuilder result = new StringBuilder();

        if(ball > 0){
            result.append(ball).append(RESULT_BALL);
        }

        if(!result.isEmpty()) {
            result.append(" ");
        }

        if(strike > 0){
            result.append(strike).append(RESULT_STRIKE);
        }

        if(strike == 3){
            result.append("\n").append(RESULT_CORRECT_MESSAGE);
        }

        return result.toString();
    }
}
