package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import model.Number;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.GameService;

class GameControllerTest {

    private GameController gameController;
    private ByteArrayOutputStream outputStreamCaptor;
    private InputStream in;
    private PrintStream out;

    public GameControllerTest() {
        this.gameController = new GameController();
    }

    /**
     * 스트림 변경
     * 미리 준비해둔 입력 스트링을 input Stream에 할당
     * output Stream을 관찰하여 출력 스트링을 스냅샷으로 저장
     */
    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        in = System.in;
        out = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void setOut() { //본래 Stream으로 되돌려 놓음
        System.setIn(in);
        System.setOut(out);
    }


    /**
     * 정답: 123
     * 유저 입력: 231, 213, 312, 123(정답)
     * 출력: 숫자를 입력해주세요: 3볼, 숫자를 입력해주세요: 2볼 1스트라이크, 숫자를 입력해주세요: 3볼, 3개의 숫자를 모두 맞히셨습니다! 게임 종료
     */
    @Test
    void oneTurnTest() {
        Number answer = new Number(new int[]{1, 2, 3});
        String input = "231\n213\n312\n123\n";
        GameService.setScanner(new Scanner(new ByteArrayInputStream(input.getBytes())));

        gameController.playOneTurn(answer);

        String output = "숫자를 입력해주세요: 3볼\n숫자를 입력해주세요: 2볼 1스트라이크\n숫자를 입력해주세요: 3볼\n숫자를 입력해주세요: 3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
        assertEquals(output, outputStreamCaptor.toString());
    }

    @Test
    void keepGoingTest() {
        String go = "1\n";
        GameService.setScanner(new Scanner(new ByteArrayInputStream(go.getBytes())));

        Assertions.assertTrue(gameController.isContinuing());
    }

    @Test
    void endTest() {
        String go = "2\n";
        GameService.setScanner(new Scanner(new ByteArrayInputStream(go.getBytes())));

        Assertions.assertFalse(gameController.isContinuing());
    }

}