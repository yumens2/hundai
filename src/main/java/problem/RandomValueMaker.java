package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomValueMaker implements ValueMaker {
    @Override
    public String makeNum() {
        // 1부터 9까지의 숫자를 담은 리스트 생성
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        // Random 객체 생성
        Random random = new Random();

        // 리스트에서 3개의 숫자를 무작위로 선택
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(numbers.size());
            sb.append(numbers.get(index));
            numbers.remove(index);
        }

        return sb.toString();
    }
}
