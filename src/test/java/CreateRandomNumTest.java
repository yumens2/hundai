import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateRandomNumTest {
    private CreateRandomNum randomNumGenerator = new CreateRandomNum();

    @Test
    @DisplayName("1~10내의 숫자인지 검사")
    void CreateRandomNum() {
        //  give

        //  when
        Integer[] randomNums = randomNumGenerator.getRandomNum();

        //  then
        assertNotNull(randomNums);
        assertTrue(randomNums.length > 0);

        for (int num : randomNums) {
            assertTrue(num >= 1 && num <= 9);
        }
    }

    @Test
    @DisplayName("해당인덱스의 숫자와 입력된 숫자가 같은지 비교")
    void isStrike() {
        //  give

        //  when
        Integer[] randomNums = randomNumGenerator.getRandomNum();

        //  then
        assertNotNull(randomNums);
        assertTrue(randomNumGenerator.isStrike(randomNums[0],0));
        assertFalse(randomNumGenerator.isStrike(randomNums[0],1));
    }

    @Test
    @DisplayName("해당인덱스의 외 숫자와 입력된 숫자가 같은지 비교")
    void isBall() {
        //  give

        //  when
        Integer[] randomNums = randomNumGenerator.getRandomNum();

        //  then
        assertNotNull(randomNums);
        assertTrue(randomNumGenerator.isBall(randomNums[0],1));
        assertFalse(randomNumGenerator.isBall(randomNums[0],0));
    }


}