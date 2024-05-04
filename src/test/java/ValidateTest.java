import Validation.ValidateInput;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ValidateTest {

    @Test
    @DisplayName("3자리 숫자가 입력되지 않을 때 유효성 검증에 성공하는지 확인")
    public void validDigit() {
        String input = "12";

        try {
            ValidateInput.isValidateInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("1~9 사이의 숫자 입력되지 않았을 때 유효성 검증에 성공하는지 확인")
    public void validValue() {
        String input = "123";

        try {
            ValidateInput.isValidateInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("중복된 숫자가 입력되었을 때 유효성 검증에 성공하는지 확인")
    public void validDuplicate() {
        String input = "112";

        try {
            ValidateInput.isValidateInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
