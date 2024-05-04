import Validation.ValidateRestart;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ContinueOrNotTest {


    @Test
    @DisplayName("1 또는 2가 입력되지 않았을 때 유효성 검증에 성공하는지 확인")
    public void validContinueOrNot() {
        String input = "3";

        try {
            ValidateRestart.isValidateRestart(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
