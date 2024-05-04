package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.dto.ResultDto;
import baseball.model.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    GameService gameService;

    @BeforeEach
    void beforeEach() {
        gameService = new GameService(new Computer());
    }

    @Test
    @DisplayName("정답: 3스트라이크")
    void isCorrect_true() {
        assertTrue(gameService.isCorrect(new ResultDto(3, 0)));
    }

    @Test
    @DisplayName("정답 아님: 1볼 2스트라이크")
    void isCorrect_false() {
        assertFalse(gameService.isCorrect(new ResultDto(2, 1)));
    }

    @Test
    @DisplayName("게임 재시작")
    void restart_true() {
        assertTrue(gameService.restart("1"));
    }

    @Test
    @DisplayName("게임 종료")
    void restart_false() {
        assertFalse(gameService.restart("2"));
    }
}