import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class JudgementTest {

    @DisplayName("스트라이크 볼 판단 테스트")
    @Test
    void judgeTest() {
        Judgement judgement=new Judgement();

        int[] strike = judgement.judge(new ArrayList(Arrays.asList(1,2,3)), new ArrayList(Arrays.asList(1,2,3)));
        int[] ball = judgement.judge(new ArrayList(Arrays.asList(2,3,1)), new ArrayList(Arrays.asList(1,2,3)));
        int[] strike_ball = judgement.judge(new ArrayList(Arrays.asList(1,2,3)), new ArrayList(Arrays.asList(1,3,2)));
        int[] not = judgement.judge(new ArrayList(Arrays.asList(1,2,3)), new ArrayList(Arrays.asList(4,5,6)));

        Assertions.assertThat(strike).isEqualTo(new int[]{0, 3});
        Assertions.assertThat(ball).isEqualTo(new int[]{3, 0});
        Assertions.assertThat(strike_ball).isEqualTo(new int[]{2, 1});
        Assertions.assertThat(not).isEqualTo(new int[]{0, 0});
    }

    @DisplayName("스트라이크 볼 결과출력 테스트")
    @Test
    void resultTest() {
        Judgement judgement=new Judgement();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        judgement.result(new int[]{0,1});
        Assertions.assertThat(out.toString().trim()).isEqualTo("1스트라이크");
    }
}