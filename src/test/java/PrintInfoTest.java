import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PrintInfoTest {

    @Test
    public void testPrintInfo() {
        assertThat(PrintInfo.printResult("11")).isEqualTo(false);
        assertThat(PrintInfo.printResult("30")).isEqualTo(true);

        // 낫싱 정상 출력 확인
        assertThatCode(() ->
            PrintInfo.printResult("00")).doesNotThrowAnyException();
        // 스트라이크 정상 출력 확인
        assertThatCode(() ->
            PrintInfo.printResult("10")).doesNotThrowAnyException();
        // 볼 정상 출력 확인
        assertThatCode(() ->
            PrintInfo.printResult("01")).doesNotThrowAnyException();
        // 볼 + 스트라이크 정상 출력 확인
        assertThatCode(() ->
            PrintInfo.printResult("11")).doesNotThrowAnyException();
    }

    @Test
    public void testUserChoice() {
        // 게임 종료 후 다시 시작할 때 정상적인 입력 테스트
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        assertThatCode(PrintInfo::userChoice)
            .doesNotThrowAnyException();

        // 게임 종료 후 종료할 때 정상적인 입력 테스트
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        assertThatCode(PrintInfo::userChoice)
            .doesNotThrowAnyException();

        // 잘못된 입력 시 예외 처리 테스트
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        assertThat(PrintInfo.userChoice())
            .isEqualTo(2);
    }
}
