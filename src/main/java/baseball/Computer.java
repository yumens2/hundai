package baseball;

import java.util.Random;

public class Computer {
    private String problemNum;
    private final Random random;

    public Computer(Random random) {
        this.random = random;
        initProblemNum();
    }

    private int makeRandomNum() {
        // 111 + random 값을 통해 111 ~ 999 숫자 중 0이 포함된 값을 제외한다
        return 111 + random.nextInt(889);
    }

    public void initProblemNum() {
        this.problemNum = String.valueOf(makeRandomNum());
    }

    public String getProblemNum() {
        return problemNum;
    }
}
