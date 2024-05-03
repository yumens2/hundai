import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest extends BaseballGame{

    // 테스트를 진행할 때는 접근 제어자들을 private가 아닌 제어자로 변경 후 테스트 진행
//    @Test
//    void gameShouldStartNotOver() {
//        BaseballGame baseballGame = new BaseballGame();
//        assertFalse(baseballGame.isGameOver, "게임은 시작할 때 게임 오버 상태가 아니어야 함.");
//    }

//    @Test
//    void IllegalArgumentThrown() {
//        BaseballGame baseballGame = new BaseballGame() {
//
//            // 테스트 시에 playTurn()의 접근제어자를 private 가 아닌 것으로 변경 후 테스트가 끝나면 private 로 다시 변경!
//            @Override
//            void playTurn() {
//                throw new IllegalArgumentException("테스트 예외");
//            }
//        };
//
//        Exception exception = assertThrows(IllegalArgumentException.class, baseballGame::playTurn, "IllegalArgumentException 이 아님");
//        assertEquals("테스트 예외", exception.getMessage(), "예외 메시지가 일치해야 합니다.");
//    }

}
