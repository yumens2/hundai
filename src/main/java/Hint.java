import constant.GameMessageConstant;
import data.GameResult;

public class Hint {

    GameResult result;

    public Hint(GameResult result) {
        this.result = result;
    }

    public String getHint() {
        if (result.ball() == 0 && result.strike() == 0) {
            return GameMessageConstant.NOTHING;
        }
        if (result.ball() == 0) {
            return strike2String(result.strike());
        }
        if (result.strike() == 0) {
            return ball2String(result.ball());
        }
        return ball2String(result.ball()) + " " + strike2String(result.strike());
    }

    private String ball2String(int ball) {
        if (ball > 0) {
            return String.format("%d%s", ball, GameMessageConstant.BALL);
        }
        return "";
    }

    private String strike2String(int strike) {
        if (strike > 0) {
            return String.format("%d%s", strike, GameMessageConstant.STRIKE);
        }
        return "";
    }
}
