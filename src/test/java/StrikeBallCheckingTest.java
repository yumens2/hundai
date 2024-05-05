import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;

public class StrikeBallCheckingTest {

    @Test
    @DisplayName("3스트라이크일 경우에 대한 테스트 사례")
    public void countStrikeBallTest_AllStrikes() {
        StrikeBallChecking sbc = new StrikeBallChecking();
        int[] cpunum = {1, 2, 3};
        int[] playernum = {1, 2, 3};
        int[] strikeballcount = new int[2];
        int[] result = sbc.countStrikeBall(cpunum, playernum, strikeballcount);

        //assertArrayEquals는 두 배열이 동일한지 확인하는데 사용됩니다.
        //모든 요소가 두 배열에서 정확히 일치하면 어설션이 통과됩니다.
        assertArrayEquals(new int[]{3, 0}, result);
    }

    @Test
    @DisplayName("3볼일 경우에 대한 테스트 사례")
    public void countStrikeBallTest_AllBalls() {
        StrikeBallChecking sbc = new StrikeBallChecking();
        int[] cpunum = {1, 2, 3};
        int[] playernum = {3, 1, 2};
        int[] strikeballcount = new int[2];
        int[] result = sbc.countStrikeBall(cpunum, playernum, strikeballcount);

        //assertArrayEquals는 두 배열이 동일한지 확인하는데 사용됩니다.
        //모든 요소가 두 배열에서 정확히 일치하면 어설션이 통과됩니다.
        assertArrayEquals(new int[]{0, 3}, result);
    }

    @Test
    @DisplayName("스트라이크와 볼이 같이 있는 경우에 대한 테스트 사례")
    public void countStrikeBallTest_StrikeBall() {
        StrikeBallChecking sbc = new StrikeBallChecking();
        int[] cpunum = {1, 2, 3};
        int[] playernum = {1, 3, 4};
        int[] strikeballcount = new int[2];
        int[] result = sbc.countStrikeBall(cpunum, playernum, strikeballcount);

        //assertArrayEquals는 두 배열이 동일한지 확인하는데 사용됩니다.
        //모든 요소가 두 배열에서 정확히 일치하면 어설션이 통과됩니다.
        assertArrayEquals(new int[]{1, 1}, result);
    }

    @Test
    @DisplayName("3스트라이크일 경우 출력문에 대한 테스트 사례")
    public void outputresultTest_AllStrikes() {
        StrikeBallChecking sbc = new StrikeBallChecking();
        int[] strikeballcount = {3, 0};
        //콘솔에 나오는 출력을 캡쳐하기 위해 ByteArrayOutputSteam을 사용했다.
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        //System.out은 표준 출력 스트림(콘솔)을 나타내는 'PrintStream' 개체입니다.
        //기본적으로 'System.out.println()'을 사용하면 출력이 콘솔로 전달됩니다.
        //여기서는 표준 출력 스트림을 'ByteArrayOutputSteam'으로 리디렉션합니다.
        //즉, 'System.out'에 기록된 모든 데이터는 콘솔에 인쇄되는 대신 'outputContent'에 의해 캡쳐됩니다.
        System.setOut(new PrintStream(outputContent));
        sbc.outputresult(strikeballcount);
        //캡쳐된 출력을 문자열로 변환하고 trim()을 이용하여 선행 또는 후행 공백 문자를 제거합니다.
        String output = outputContent.toString().trim();
        //assertEquals는 두 값이 같은지 비교합니다. 두 문자열이 정확히 같으면 어설션이 통과됩니다.
        assertEquals("3스트라이크", output);
    }

    @Test
    @DisplayName("3볼일 경우 출력문에 대한 테스트 사례")
    public void outputresultTest_AllBalls() {
        StrikeBallChecking sbc = new StrikeBallChecking();
        int[] strikeballcount = {0, 3};
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        sbc.outputresult(strikeballcount);
        String output = outputContent.toString().trim();
        assertEquals("3볼", output);
    }

    @Test
    @DisplayName("스트라이크와 볼이 있는 경우 출력문에 대한 테스트 사례")
    public void outputresultTest_StrikeBall() {
        StrikeBallChecking sbc = new StrikeBallChecking();
        int[] strikeballcount = {1, 1};
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        sbc.outputresult(strikeballcount);
        String output = outputContent.toString().trim();
        assertEquals("1볼 1스트라이크", output);
    }

    @Test
    @DisplayName("낫싱일 경우 출력문에 대한 테스트 사례")
    public void outputresultTest_Nothing() {
        StrikeBallChecking sbc = new StrikeBallChecking();
        int[] strikeballcount = {0, 0};
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        sbc.outputresult(strikeballcount);
        String output = outputContent.toString().trim();
        assertEquals("낫싱", output);
    }
}
