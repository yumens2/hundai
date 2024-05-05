import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import service.GameService;

public class GameServiceTest
{
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
        gameService.setSecretNumber("123");
    }

    @Test
    void testExactMatch() {
        String result = gameService.checkGuess("123");
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void testPartialMatch() {
        String result = gameService.checkGuess("189");
        assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    void testWrongNumber() {
        String result = gameService.checkGuess("789");
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void testMixedMatch() {
        String result = gameService.checkGuess("132");
        assertThat(result).isEqualTo("2볼 1스트라이크");
    }
}
