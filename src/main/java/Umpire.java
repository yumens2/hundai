public class Umpire {

    private final BaseballCount baseballCount;

    public Umpire() {
        this.baseballCount = new BaseballCount();
    }

    public void setBaseballCountWithCalculator(Player player, Computer computer) {
        int ballCount = BaseballCountCalculator.countBall(player.getPlayerNumber(), computer.getAnswerNumber());
        int strikeCount = BaseballCountCalculator.countStrike(player.getPlayerNumber(), computer.getAnswerNumber());
        ballCount = BaseballCountCalculator.countBallExceptForStrike(ballCount, strikeCount);
        baseballCount.setBaseballCount(ballCount, strikeCount);
    }

    public BaseballCount getBaseballCount() {
        return baseballCount;
    }

    public boolean isPlayerWin() {
        return baseballCount.getStrikeCount() == 3;
    }
}
