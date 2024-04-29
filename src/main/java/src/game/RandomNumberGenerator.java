package src.game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

    public static int generateRandomNumber() {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();

        while (set.size() < 3) {
            set.add(random.nextInt(9) + 1);
        }

        return set.stream()
                .map(String::valueOf)           // 숫자를 합치기 위해 문자열로 변환
                .reduce((s1, s2) -> s1 + s2)    // 세 숫자를 하나로 합침
                .map(Integer::parseInt)         // 정수로 다시 변환
                .orElseThrow(IllegalArgumentException::new);
    }
}
