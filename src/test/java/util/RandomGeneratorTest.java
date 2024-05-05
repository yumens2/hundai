package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("중복값 없는 랜덤값 생성 테스트")
    void generateRandomValuesWithNoDuplicatedTest(){
        //given
        int capacity = 3;

        //when
        List<Integer> randomValues = RandomGenerator.generateRandomValue(capacity);

        //then
        assertEquals(new HashSet<>(randomValues).size(), 3);
    }

    @RepeatedTest(100)
    @DisplayName("모든 값이 1 ~ 9 사이에 있는지 테스트")
    void generateRandomValuesWithInRangeTest(){
        //given
        int capacity = 3;

        //when
        List<Integer> randomValues = RandomGenerator.generateRandomValue(capacity);

        //then
        for(Integer value : randomValues){
            assertTrue((value < 10) && (value > 0));
        }
    }
}