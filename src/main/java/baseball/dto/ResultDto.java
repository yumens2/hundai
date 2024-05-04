package baseball.dto;

public class ResultDto {

    private Integer strike;
    private Integer ball;

    public ResultDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
