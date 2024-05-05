package service;

public class GameService implements ITestGameService {
    private int ballCount;
    private int strikeCount;

    public void countBall(int[] userNumbers, int[] computerNumbers) {
        ballCount = 0;
        strikeCount = 0;
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

    public void countStrike(int[] userNumbers, int[] computerNumbers) {
        strikeCount = 0;
        for(int i = 0; i < 3; i++) {
            if(userNumbers[i] == computerNumbers[i]) {
                ballCount--;
                strikeCount++;
            }
        }
    }

    public String getFeedback() {
        if(strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        } else if(strikeCount == 0) {
            return ballCount + "볼";
        } else if(ballCount == 0) {
            return strikeCount + "스트라이크";
        } else {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
    }
    @Override
    public int getBallCount() {
        return ballCount;
    }

    @Override
    public int getStrikeCount() {
        return strikeCount;
    }
}
