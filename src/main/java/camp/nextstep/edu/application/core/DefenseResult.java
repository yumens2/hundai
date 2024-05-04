package camp.nextstep.edu.application.core;

public record DefenseResult(
        int strikesCount,
        int ballCount
) {

    public boolean isNothing() {
        return strikesCount == 0 && ballCount == 0;
    }

    public boolean isStrikeOut() {
        return strikesCount == 3;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean blankFlag = false;
        if(ballCount > 0) {
            result.append(ballCount).append("볼");
            blankFlag = true;
        }
        if (strikesCount > 0) {
            if(blankFlag) result.append(" ");
            result.append(strikesCount).append("스트라이크");
        }
        if (isNothing()) {
            result.append("낫싱");
        }
        return result.toString();
    }
}