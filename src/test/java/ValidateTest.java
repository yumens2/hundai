import Validation.ValidateInput;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class ValidateTest {

    @Test
    @DisplayName("3자리 숫자가 입력되지 않을 때 유효성 검증에 성공하는지 확인")
    public void validDigit() {
        ArrayList<String> input = new ArrayList<>();
        input.add("12");
        input.add("1234");
        input.add("12345");

        for (String s : input) {
            try {
                ValidateInput.isValidateInput(s);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("1~9 사이의 숫자 입력되지 않았을 때 유효성 검증에 성공하는지 확인")
    public void validValue() {
        ArrayList<String> input = new ArrayList<>();
        input.add("012");
        input.add("가나다");
        input.add("ABC");

        for (String s : input) {
            try {
                ValidateInput.isValidateInput(s);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("중복된 숫자가 입력되었을 때 유효성 검증에 성공하는지 확인")
    public void validDuplicate() {
        ArrayList<String> input = new ArrayList<>();
        input.add("112");
        input.add("446");
        input.add("989");

        for (String s : input) {
            try {
                ValidateInput.isValidateInput(s);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
