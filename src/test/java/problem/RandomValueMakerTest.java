package problem;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomValueMakerTest {
    @Test
    public void testMakeNum_Length() {
        RandomValueMaker maker = new RandomValueMaker();
        String result = maker.makeNum();
        assertEquals(3, result.length(), "생성된 문자열의 길이가 3이 아닙니다.");
    }

    @Test
    public void testMakeNum_OnlyDigits() {
        RandomValueMaker maker = new RandomValueMaker();
        String result = maker.makeNum();
        assertTrue(result.matches("[1-9]+"), "생성된 문자열에 1부터 9까지의 숫자 외 다른 문자가 포함되어 있습니다.");
    }

    @Test
    public void testMakeNum_NoDuplicates() {
        RandomValueMaker maker = new RandomValueMaker();
        String result = maker.makeNum();
        Set<Character> charSet = new HashSet<>();
        for (char c : result.toCharArray()) {
            charSet.add(c);
        }
        assertEquals(3, charSet.size(), "생성된 문자열에 중복된 숫자가 있습니다.");
    }
}
