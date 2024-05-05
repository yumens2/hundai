import static org.assertj.core.api.Assertions.assertThat;

import baseball.Baseball;
import baseball.Referee;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballTest {
    @DisplayName("3볼 테스트")
    @Test
    void ball(){
        Referee referee = new Referee();
        assertThat(referee.ballCount(referee.ball(Arrays.asList(1,3,5),Arrays.asList(5,1,3)),
            referee.strike(Arrays.asList(1,3,5),Arrays.asList(5,1,3))).equals("3볼"));
    }
    @DisplayName("3스트라이크 테스트")
    @Test
    void strike(){
        Referee referee = new Referee();
        assertThat(referee.ballCount(referee.ball(Arrays.asList(1,3,5),Arrays.asList(1,3,5)),
            referee.strike(Arrays.asList(1,3,5),Arrays.asList(1,3,5))).equals("3스트라이크"));
    }
    @DisplayName("1볼 1스트라이크 테스트")
    @Test
    void ballStrike(){
        Referee referee = new Referee();
        assertThat(referee.ballCount(referee.ball(Arrays.asList(1,3,5),Arrays.asList(5,3,4)),
            referee.strike(Arrays.asList(1,3,5),Arrays.asList(5,3,4))).equals("1볼 1스트라이크"));
    }

    @DisplayName("낫싱 테스트")
    @Test
    void nothings(){
        Referee referee = new Referee();
        assertThat(referee.ballCount(referee.ball(Arrays.asList(1,3,5),Arrays.asList(2,4,6)),
            referee.strike(Arrays.asList(1,3,5),Arrays.asList(2,4,6))).equals("낫싱"));
    }

    @DisplayName("재시작 테스트")
    @Test
    void replay(){
        Baseball baseball= new Baseball();
        String re="1";
        OutputStream out =new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in =new ByteArrayInputStream(re.getBytes());
        System.setIn(in);
        assertThat(baseball.replay()).isEqualTo(true);
    }
    @DisplayName("재시작 테스트")
    @Test
    void notReplay(){
        Baseball baseball= new Baseball();
        String re="2";
        OutputStream out =new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in =new ByteArrayInputStream(re.getBytes());
        System.setIn(in);
        assertThat(baseball.replay()).isEqualTo(false);
    }
}
