import static org.assertj.core.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class NumberGeneratorTest {

  @RepeatedTest(10)
  @DisplayName("랜덤 숫자 생성 테스트")
  public void testGenerateRandomNumber(){
    List<Integer> randomNumber = NumberGenerator.generateRandomNumber();
    Set<Integer> uniqueNumbers = new HashSet<>(randomNumber);

    assertThat(uniqueNumbers).hasSize(3);
  }
}
