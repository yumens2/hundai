import static org.assertj.core.api.Fail.fail;

import org.junit.jupiter.api.Test;

public class valid_string_test {
    @Test
    public void valid_input_test() {
        // 유효한 문자열을 사용하여 메서드 호출
        String validInput = "123";
        try {
            BaseballGame.valid_string(validInput);
            // 예외가 발생하지 않으면 테스트 통과
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 테스트 실패
            fail("예외가 발생하면 안 된다.");
        }
    }

    @Test
    public void invalid_input_test() {
        // 예외가 발생되어야하는 case
        String invalidInput = "ska2819";
        try {
            BaseballGame.valid_string(invalidInput);
            // 예외가 발생하지 않으면 테스트 실패
            fail("예외가 발생해야 한다.");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 테스트 통과
        }
    }

    @Test
    public void invalid_input_test2() {
        // 예외가 발생되어야하는 case
        String invalidInput = "83a";
        try {
            BaseballGame.valid_string(invalidInput);
            // 예외가 발생하지 않으면 테스트 실패
            fail("예외가 발생해야 한다.");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 테스트 통과
        }
    }

}
