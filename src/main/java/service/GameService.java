package service;

public class GameService implements ITestGameService {
    private int ballCount;
    private int strikeCount;

    public void countBall(int[] userNumbers, int[] computerNumbers) {
        ballCount = 0;
        for(int userNumber : userNumbers) {
            ballCount += checkNumber(userNumber, computerNumbers);
        }
    }

    private int checkNumber(int userNumber, int[] computerNumbers) {
        for(int computerNumber : computerNumbers) {
            if(userNumber == computerNumber) {
                return 1;
            }
        }
        return 0;
    }

    void countStrike() {}

    @Override
    public int getBallCount() {
        return ballCount;
    }

    @Override
    public int getStrikeCount() {
        return strikeCount;
    }
}
