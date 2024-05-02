import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public Computer() {
        this.numbers = computerRandomNumbers();
    }

    // 1~9 범위의 중복되지 않는 수 3개를 뽑아내는 함수
    private List<Integer> computerRandomNumbers() {
        List<Integer> numList = new ArrayList<>();

        // 먼저 1~9를 numList 에 넣음
        for (int i = 1; i <= 9; i++) {
            numList.add(i);
        }
        // 수를 섞음
        Collections.shuffle(numList);
        // 인덱스 0~2까지(총 3개)를 반환
        return numList.subList(0, 3);
    }

    public List<Integer> getComputerNumbers() {
        return numbers;
    }
}
