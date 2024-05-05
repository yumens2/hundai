package userinterface;

import static org.junit.jupiter.api.Assertions.*;

import domain.Result;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserResponseTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void printGuessMessage() {
        UserResponse userResponse = new UserResponse();

        userResponse.printGuessMessage();

        assertEquals("숫자를 입력해주세요 : ", outputStreamCaptor.toString());
    }

    @Test
    void printResult() {
        UserResponse userResponse = new UserResponse();

        Result result = new Result();

        result.calculate("123", List.of(1, 2, 3));
        userResponse.printResult(result);
        assertEquals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();

        result.calculate("123", List.of(2, 3, 1));
        userResponse.printResult(result);
        assertEquals("3볼", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();

        result.calculate("123", List.of(4, 5, 6));
        userResponse.printResult(result);
        assertEquals("낫싱", outputStreamCaptor.toString().trim());
    }

    @Test
    void printReplayMessage() {
        UserResponse userResponse = new UserResponse();

        userResponse.printReplayMessage();

        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", outputStreamCaptor.toString().trim());
    }
}