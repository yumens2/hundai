import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

public class ContinueGameTest {

    //ByteArrayInputStream은 메모리의 배열에서 바이트를 읽는 InputStream의 하위 클래스
    //바이트 배열에서 바이트를 읽는 입력 스트림을 생성할 수 있다.
    //실제 외부 소스를 사용하지 않고 입력 데이터를 시뮬레이션하는 테스트에 유용하다.
    private ByteArrayInputStream testIn;

    @Test
    @DisplayName("1을 입력했을 경우")
    public void continueorexitTest_1Input() {
        //"1"로 사용자 지정 입력 스트림을 설정함
        testIn = new ByteArrayInputStream("1".getBytes());
        //시스템의 표준 입력 스트림을 재지정하는 역할을 한다.
        //설정된 표준 입력 스트림은 이제 testIn이 가리키는 ByteArrayInputStream으로 변경됨
        //그러므로 프로그램은 사용자의 입력을 testIn에서 읽어들인다고 간주
        //실제로는 사용자의 입력이 아닌 미리 설정된 데이터를 읽는 것
        System.setIn(testIn);

        ContinueGame cg = new ContinueGame();
        int result = cg.continueorexit();

        //1을 입력했을 때와 1이 같은지 확인 후 같으면 어설션이 통과됩니다.
        assertEquals(1, result);
    }

    @Test
    @DisplayName("2를 입력했을 경우")
    public void continueorexitTest_2Input() {
        testIn = new ByteArrayInputStream("2".getBytes());
        System.setIn(testIn);

        ContinueGame cg = new ContinueGame();
        int result = cg.continueorexit();

        assertEquals(2, result);
    }

    @Test
    @DisplayName("1이나 2가 아닌 정수를 입력했을 경우")
    public void continueorexitTest_InvalidInput() {
        testIn = new ByteArrayInputStream("3".getBytes());
        System.setIn(testIn);

        ContinueGame cg = new ContinueGame();

        //assertThrows() 메서드의 사용법은 다음과 같다.
        //assertThrows(ExpectedException.class, () -> {
        // //예외가 발생할 것으로 예상되는 코드 블록
        //});
        //ExpectedException.class는 기대되는 예외의 클래스 입니다.
        //여기서는 IllegalArgumentException을 throw를 했으므로 IllegalArgumentException.class로 작성합니다.
        //이 코드는 IllegalArgumentException이 발생하는지 확인하고
        //발생한 예외를 exception이라는 변수에 할당하는 것입니다.
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cg.continueorexit();
        });
        //exception.getMessage()를 사용해 테스트에서 IllegalArgumentException이 발생했을 때
        //나오는 메시지인 오류 메시지를 나타냅니다.
        //오류 메시지가 같다면 어설션이 통과됩니다.
        assertEquals("잘못 입력했습니다. 1 또는 2만 입력 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("정수가 아닌 다른 값을 입력했을 경우")
    public void testContinueGame_NoIntegerInput() {
        testIn = new ByteArrayInputStream("abc".getBytes());
        System.setIn(testIn);

        ContinueGame cg = new ContinueGame();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cg.continueorexit();
        });

        assertEquals("잘못 입력했습니다. 1 또는 2만 입력 가능합니다.", exception.getMessage());
    }
}