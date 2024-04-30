public class Hint {
    public static final int YES = 1;
    public static final int NO = 0;

    private int numberOfStrike;
    private int numberOfBall;

    Hint() {
        numberOfStrike = 0;
        numberOfBall = 0;
    }

    public int printAnswer() {
        int ContinueUserSet = YES;

        if (numberOfBall != 0) {
            System.out.printf("%d볼 ", numberOfBall);
        }
        if (numberOfStrike != 0) {
            System.out.printf("%d스트라이크", numberOfStrike);
            if (numberOfStrike == 3)
                ContinueUserSet = NO;
        }
        if (numberOfBall == 0 && numberOfStrike == 0) {
            System.out.printf("낫싱");
        }
        System.out.println();

        return ContinueUserSet;
    }

    public void setNumberOfStrike(int numberOfStrike) {
        this.numberOfStrike = numberOfStrike;
    }

    public void setNumberOfBall(int numberOfBall) {
        this.numberOfBall = numberOfBall;
    }
}
