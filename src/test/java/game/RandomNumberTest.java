package game;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberTest {
    @Test
    void testThreeRandomNumber() {
        for (int i=0; i<100; i++) {
            String randomNumber = makeRandomNumber();
            assertNotEquals(randomNumber.charAt(0), randomNumber.charAt(1));
            assertNotEquals(randomNumber.charAt(1), randomNumber.charAt(2));
            assertNotEquals(randomNumber.charAt(0), randomNumber.charAt(2));
            assertEquals(3, randomNumber.length());
        }
    }

    private String makeRandomNumber() {
        Set<Integer> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        while (set.size() != 3)
            set.add(makeRandomNumber(1, 9));
        List<Integer> randomNumber = set.stream().collect(Collectors.toList());
        Collections.shuffle(randomNumber);
        for (int num : randomNumber)
            result.append(num);
        return result.toString();
    }

    private int makeRandomNumber(int start, int end) {
        return (int) (Math.random() * end) + start;
    }
}