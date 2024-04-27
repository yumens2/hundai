package baseball;

import java.util.Random;

public class Computer {
    private int problemNum;
    private static final Random random = new Random();

    public Computer() {
        this.problemNum = makeRandomNum();
    }

    public int makeRandomNum() {
        // 111 + random 값을 통해 111 ~ 999 숫자 중 0이 포함된 값을 제외한다
        return 111 + random.nextInt(889);
    }

    public void reInitProblemNum() {
        this.problemNum = makeRandomNum();
    }

    public int getProblemNum() {
        return problemNum;
    }
}
