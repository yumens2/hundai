import java.util.Scanner;
import model.Baseball;
import model.BaseballService;
import model.BaseballServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballInitTest {

  BaseballService baseballService;

  @Test
  @DisplayName("랜덤 번호가 생성되어야 한다")
  void random_number_create() {
    Baseball baseball = new Baseball();
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    for (int i = 0; i < 10; i++) {
      baseballService.baseballInit();
      System.out.println(baseball);
    }
  }
}
