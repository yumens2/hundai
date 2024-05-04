import Validation.ValidateRestart;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class ContinueOrNotTest {


    @Test
    @DisplayName("1 또는 2가 입력되지 않았을 때 유효성 검증에 성공하는지 확인")
    public void validContinueOrNot() {
        ArrayList<String> input = new ArrayList<>();
        input.add("3");
        input.add("4");

        for (String s : input) {
            try {
                ValidateRestart.isValidateRestart(s);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
