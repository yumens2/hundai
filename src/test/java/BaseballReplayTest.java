import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import model.Baseball;
import model.BaseballService;
import model.BaseballServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballReplayTest {

  BaseballService baseballService;

  @Test
  @DisplayName("replay()시 유효하지 않은 값")
  void invalid_replay() {
    //given
    String s = "a";
    InputStream in = new ByteArrayInputStream(s.getBytes());
    System.setIn(in);
    Baseball baseball = new Baseball();
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    //then
    assertThrows(IllegalArgumentException.class, () -> {
      baseballService.replay();
    });
  }
}
