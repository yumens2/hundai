import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class b_s_print_test {
    @Test
    public void testCheckExit() throws IOException {
        //1차 테스트
        // 표준 출력을 임시로 캡처하기 위한 ByteArrayOutputStream 생성
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 임의 판정 결과 생성
        int[] judgement = {2, 1};

        // 메서드 호출
        BaseballGame.b_s_print(judgement);

        // 표준 출력에서 캡처한 내용을 문자열로 변환하여 확인
        String expectedOutput = "2볼 1스트라이크"; // 예상되는 출력 메시지
        String capturedOutput = outContent.toString().trim(); // 문자열 앞뒤의 공백 및 줄 바꿈 문자 제거
        assertEquals(expectedOutput, capturedOutput);

        // 표준 출력을 원래대로 되돌림
        System.setOut(System.out);

        //2차 테스트
        // 표준 출력을 임시로 캡처하기 위한 ByteArrayOutputStream 생성
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 임의 판정 결과 생성
        int[] judgement2 = {0, 3};

        // 메서드 호출
        BaseballGame.b_s_print(judgement2);

        // 표준 출력에서 캡처한 내용을 문자열로 변환하여 확인
        String expectedOutput2 = "3스트라이크"; // 예상되는 출력 메시지
        String capturedOutput2 = outContent.toString().trim(); // 문자열 앞뒤의 공백 및 줄 바꿈 문자 제거
        assertEquals(expectedOutput2, capturedOutput2);
    }

}
