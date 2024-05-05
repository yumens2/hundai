package service;

public interface ITestGameService {
    void countBall(int[] userNumbers, int[] computerNumbers);
    int getBallCount();
    int getStrikeCount();
}
