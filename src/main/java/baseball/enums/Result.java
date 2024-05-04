package baseball.enums;

import baseball.dto.ResultDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Result {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String value;

    public static String toString(ResultDto resultDto) {
        int strike = resultDto.getStrike();
        int ball = resultDto.getBall();

        if (strike == 0 && ball == 0) {
            return NOTHING.value;
        }

        String result = "";
        if (ball > 0) {
            result += ball + BALL.value;
        }
        if (strike > 0) {
            if (!result.isEmpty()) result += " ";
            result += strike + STRIKE.value;
        }
        return result;
    }
}
