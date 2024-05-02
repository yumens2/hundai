//import baseball.domain.Computer;
//import baseball.service.GameService;
//import baseball.service.ScoreService;
//import java.util.Arrays;
//import java.util.List;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//
//public class ServiceTest {
//
//    private GameService gameService;
//    private Computer computer;
//
//    private ScoreService scoreService;
//
//    @BeforeEach
//    public void setup() {
//        gameService = new GameService();
//        computer = new Computer();
//        scoreService = new ScoreService();
//    }
//
//    @Test
//    public void setEndGame_ShouldRestartGame() {
//
//        int restartOrEnd = 1;
//
//        gameService.setEndGame(restartOrEnd, computer);
//
//        Assertions.assertFalse(gameService.isEndGame());
//    }
//
//    @Test
//    public void setEndGame_ShouldEndGame() {
//
//        int restartOrEnd = 2;
//
//        gameService.setEndGame(restartOrEnd, computer);
//
//        Assertions.assertTrue(gameService.isEndGame());
//    }
//
//    public void getScore_ShouldReturnCorrectScoreForStrike() {
//        // 1s
//        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
//        List<Integer> computerNumbers = Arrays.asList(1, 4, 5);
//
//        int[] result = scoreService.getScore(playerNumbers, computerNumbers);
//
//        Assertions.assertEquals(1, result[0]); // 스트라이크 수 확인
//        Assertions.assertEquals(0, result[1]); // 볼 수 확인
//    }
//
//    @Test
//    public void getScore_ShouldReturnCorrectScoreForBall() {
//        // 1b
//        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
//        List<Integer> computerNumbers = Arrays.asList(4, 1, 5);
//
//        int[] result = scoreService.getScore(playerNumbers, computerNumbers);
//
//        Assertions.assertEquals(0, result[0]); // 스트라이크 수 확인
//        Assertions.assertEquals(1, result[1]); // 볼 수 확인
//    }
//
//    @Test
//    public void getScore_ShouldReturnCorrectScoreForStrikeAndBall() {
//        // 1s 1b
//        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
//        List<Integer> computerNumbers = Arrays.asList(1, 5, 2);
//
//        int[] result = scoreService.getScore(playerNumbers, computerNumbers);
//
//        Assertions.assertEquals(1, result[0]); // 스트라이크 수 확인
//        Assertions.assertEquals(1, result[1]); // 볼 수 확인
//    }
//
//    @Test
//    public void getScore_ShouldReturnZeroForNoMatch() {
//        // 0s 0b
//        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
//        List<Integer> computerNumbers = Arrays.asList(4, 5, 6);
//
//        int[] result = scoreService.getScore(playerNumbers, computerNumbers);
//
//        Assertions.assertEquals(0, result[0]); // 스트라이크 수 확인
//        Assertions.assertEquals(0, result[1]); // 볼 수 확인
//    }
//}