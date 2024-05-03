package game;

import game.gamePack.BaseballGame.config.BaseballGameConfig;
import game.gamePack.BaseballGame.model.Computer;
import game.gamePack.BaseballGame.model.Result;
import game.gamePack.BaseballGame.service.BaseballGameService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class multiThreadTest {

    @Test
    @DisplayName("멀티스레드환경에서 BaseballService 개수 1개인지 확인")
    void multiThreadBaseballServiceTest() {
        // given
        Map<String, BaseballGameService> baseballGameServiceMap = new ConcurrentHashMap<>();
        var executorService = Executors.newFixedThreadPool(1000);

        // When
        IntStream.range(0, 10000).forEach((index) -> executorService.submit(() -> {
            BaseballGameService baseballGameService = BaseballGameConfig.getBaseballGameService();
            baseballGameServiceMap.put(baseballGameService.toString(), baseballGameService);
        }));

        // Then
        Assertions.assertEquals(1, baseballGameServiceMap.size());
    }

    @Test
    @DisplayName("멀티스레드환경에서 Computer 개수 1개인지 확인")
    void multiThreadComputerTest() {
        // given
        Map<String, Computer> computerMap = new ConcurrentHashMap<>();
        var executorService = Executors.newFixedThreadPool(1000);
        // When
        IntStream.range(0, 100000).forEach((index) -> executorService.submit(() -> {
            Computer computer = Computer.of();
            computerMap.put(computer.toString(), computer);
        }));

        // Then
        Assertions.assertEquals(1, computerMap.size());
    }

    @Test
    @DisplayName("멀티스레드환경에서 Result 개수 1개인지 확인")
    void multiThreadResultTest() {
        // given
        Map<String, Result> baseballGameResultMap = new ConcurrentHashMap<>();
        var executorService = Executors.newFixedThreadPool(1000);

        // When
        IntStream.range(0, 10000).forEach((index) -> executorService.submit(() -> {
            Result result = Result.of();
            baseballGameResultMap.put(result.toString(), result);
        }));

        // Then
        Assertions.assertEquals(1, baseballGameResultMap.size());
    }


}
