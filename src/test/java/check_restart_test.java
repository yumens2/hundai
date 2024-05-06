import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import java.io.*;

public class check_restart_test {

    @Test
    public void testCheckRestartWithInputOne() throws IOException {
        // 사용자 입력 설정
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        // 표준 출력을 임시로 캡처하기 위한 ByteArrayOutputStream 생성
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 판정 결과 생성
        int[] judgement = {0, 3}; // 예상되는 판정 결과

        // 메서드 호출
        int result = Application.check_restart(judgement);

        // 표준 출력에서 캡처한 내용을 문자열로 변환하여 확인
        String expectedOutput = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        String capturedOutput = outContent.toString().trim();

        // 줄 바꿈 문자를 일관성 있게 변경하여 비교 -> 그렇지 않으면 겉으로는 문자열이 같아 보여도 test pass에 실패한다.
        String normalizedExpectedOutput = expectedOutput.replace("\r\n", "\n");
        String normalizedCapturedOutput = capturedOutput.replace("\r\n", "\n");

        // 결과 검증
        //assertEquals(expectedOutput, capturedOutput);
        assertEquals(normalizedExpectedOutput, normalizedCapturedOutput);
        assertEquals(1, result); // 예상 결과: 1 (게임 재시작)
    }

    @Test
    public void testCheckRestartWithInputTwo() throws IOException {
        // 사용자 입력 설정
        ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in);

        // 표준 출력을 임시로 캡처하기 위한 ByteArrayOutputStream 생성
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 판정 결과 생성
        int[] judgement = {0, 3}; // 예상되는 판정 결과

        // 메서드 호출
        int result = Application.check_restart(judgement);

        // 표준 출력에서 캡처한 내용을 문자열로 변환하여 확인
        String expectedOutput = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        String capturedOutput = outContent.toString().trim();

        // 줄 바꿈 문자를 일관성 있게 변경하여 비교 -> 그렇지 않으면 겉으로는 문자열이 같아 보여도 test pass에 실패한다.
        String normalizedExpectedOutput = expectedOutput.replace("\r\n", "\n");
        String normalizedCapturedOutput = capturedOutput.replace("\r\n", "\n");

        // 결과 검증
        //assertEquals(expectedOutput, capturedOutput);
        assertEquals(normalizedExpectedOutput, normalizedCapturedOutput);
        assertEquals(2, result); // 예상 결과: 1 (게임 재시작)
    }

}
