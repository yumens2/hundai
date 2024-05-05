package utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ConsoleMessagePrinterTest {

    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private String getOutput() {
        return outputStreamCaptor.toString();
    }

    @Test
    @DisplayName("Player Number 입력 메시지 출력 테스트")
    void printPlayerNumberInputMessage() {
        ConsoleMessagePrinter.printPlayerNumberInputMessage();
        Assertions.assertThat(getOutput()).isEqualTo("숫자를 입력해 주세요 : ");
    }

    @ParameterizedTest
    @DisplayName("볼 카운트 힌트 메시지 출력 테스트")
    @ValueSource(ints = {1, 2, 3})
    void printBallCountHintMessage(int ballCount) {
        ConsoleMessagePrinter.printBallCountHintMessage(ballCount);
        Assertions.assertThat(getOutput()).isEqualTo(ballCount + "볼 ");
    }

    @ParameterizedTest
    @DisplayName("스트라이크 카운트 힌트 메시지 출력 테스트")
    @ValueSource(ints = {1, 2, 3})
    void printStrikeCountHintMessage(int strikeCount) {
        ConsoleMessagePrinter.printStrikeCountHintMessage(strikeCount);
        Assertions.assertThat(getOutput()).isEqualTo(strikeCount + "스트라이크 ");
    }

    @Test
    @DisplayName("낫싱 힌트 메시지 출력 테스트")
    void printNothingHintMessage() {
        ConsoleMessagePrinter.printNothingHintMessage();
        Assertions.assertThat(getOutput().trim()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("줄바꿈 메시지 출력 테스트")
    void printLineBreak() {
        ConsoleMessagePrinter.printLineBreak();
        Assertions.assertThat(getOutput().trim()).isEqualTo("");
    }

    @Test
    @DisplayName("게임 종료 메시지 출력 테스트")
    void printGameOverMessage() {
        ConsoleMessagePrinter.printGameOverMessage();
        Assertions.assertThat(getOutput().trim()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    @DisplayName("게임 재시작 메시지 출력 테스트")
    void printGameRestartInputMessage() {
        ConsoleMessagePrinter.printGameRestartInputMessage();
        Assertions.assertThat(getOutput().trim()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}