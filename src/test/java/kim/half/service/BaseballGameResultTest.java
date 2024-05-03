package kim.half.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import kim.half.domain.BaseballFactory;
import kim.half.domain.Baseballs;
import kim.half.ui.OutputBuilder;
import org.junit.jupiter.api.Test;

public class BaseballGameResultTest {

    @Test
    void testGetResultWithNothing() {
        // Arrange
        Baseballs computerBaseballs = BaseballFactory.createBaseballs("123");
        Baseballs userBaseballs = BaseballFactory.createBaseballs("456");
        BaseballGameResult baseballGameResult = new BaseballGameResult(computerBaseballs,
            userBaseballs);

        // Test and Verify
        assertEquals(OutputBuilder.RESULT_NOTHING_MESSAGE, baseballGameResult.getResult());
    }

    @Test
    void testGetResultWithStrikeOnly() {
        // Arrange
        Baseballs computerBaseballs = BaseballFactory.createBaseballs("123");
        Baseballs userBaseballs = BaseballFactory.createBaseballs("156");
        BaseballGameResult baseballGameResult = new BaseballGameResult(computerBaseballs,
            userBaseballs);

        // Test and Verify
        assertEquals("1" + OutputBuilder.RESULT_STRIKE_MESSAGE, baseballGameResult.getResult());
    }

    @Test
    void testGetResultWithBallOnly() {
        // Arrange
        Baseballs computerBaseballs = BaseballFactory.createBaseballs("123");
        Baseballs userBaseballs = BaseballFactory.createBaseballs("256");
        BaseballGameResult baseballGameResult = new BaseballGameResult(computerBaseballs,
            userBaseballs);

        // Test and Verify
        assertEquals("1" + OutputBuilder.RESULT_BALL_MESSAGE, baseballGameResult.getResult());
    }

    @Test
    void testGetResultWithStrikeAndBall() {
        // Arrange
        Baseballs computerBaseballs = BaseballFactory.createBaseballs("123");
        Baseballs userBaseballs = BaseballFactory.createBaseballs("152");
        BaseballGameResult baseballGameResult = new BaseballGameResult(computerBaseballs,
            userBaseballs);

        // Test and Verify
        assertEquals(
            "1" + OutputBuilder.RESULT_STRIKE_MESSAGE + "1" + OutputBuilder.RESULT_BALL_MESSAGE,
            baseballGameResult.getResult());
    }
}
