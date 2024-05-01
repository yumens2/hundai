package dto;

public class GameResultDTO {
    private final int capacity;
    private final int strike;
    private final int ball;

    public GameResultDTO(final int capacity, final int strike, final int ball){
        this.capacity = capacity;
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean gameEnded(){
        return strike == capacity;
    }
}
