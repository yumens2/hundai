import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import model.AnalyseBaseballNumber;
import model.BaseballNumberGenerator;
import model.GamePlayer;
import org.junit.jupiter.api.Test;

public class BaseballNumberGameTest {

    @Test
    public void baseballNumberTest() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        String numberString = baseballNumberGenerator.generateBaseballNumberString(3);
        int number = Integer.parseInt(numberString);
        assertThat(number >= 123 && number <= 987).isTrue();
    }

    @Test
    public void userInputInvalidTest() {
        AnalyseBaseballNumber analyzer = new AnalyseBaseballNumber();
        GamePlayer gamePlayer = new GamePlayer();

        String userInput = "asd";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        assertThatIllegalArgumentException().isThrownBy(() -> gamePlayer.userActing(3, analyzer));

        userInput = "12341234";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        assertThatIllegalArgumentException().isThrownBy(() -> gamePlayer.userActing(3, analyzer));
    }

    @Test
    public void strikeTest() {
        AnalyseBaseballNumber analyzer = new AnalyseBaseballNumber();
        analyzer.setComputerNumberString("723");

        assertThat(analyzer.getResponse("721")).isEqualTo("2스트라이크");
    }

    @Test
    public void ballTest() {
        AnalyseBaseballNumber analyzer = new AnalyseBaseballNumber();
        analyzer.setComputerNumberString("723");

        assertThat(analyzer.getResponse("245")).isEqualTo("1볼");
    }

    @Test
    public void hitTest() {
        AnalyseBaseballNumber analyzer = new AnalyseBaseballNumber();
        analyzer.setComputerNumberString("351");

        assertThat(analyzer.getResponse("351")).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
