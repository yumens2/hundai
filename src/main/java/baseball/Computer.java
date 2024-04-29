package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private String problemNum;
    private final Random random;
    private static final int DIGIT_COUNT = 3;

    public Computer(Random random) {
        this.random = random;
        initProblemNum();
    }

    private String makeRandomNum() {
        List<String> numberList = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        StringBuilder randomNum = new StringBuilder();

        for (int i = 0; i < DIGIT_COUNT; ++i) {
            int idx = random.nextInt(numberList.size());
            randomNum.append(numberList.get(idx));
            // i와 numberList 는 관계가 없다. 무시 해도 되는 Warning 이다
            numberList.remove(idx);
        }

        return randomNum.toString();
    }

    public void initProblemNum() {
        this.problemNum = makeRandomNum();
    }

    public String getProblemNum() {
        return problemNum;
    }
}
