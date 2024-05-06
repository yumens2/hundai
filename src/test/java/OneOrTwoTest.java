import static org.assertj.core.api.Fail.fail;

import org.junit.jupiter.api.Test;

public class OneOrTwoTest {

    @Test
    public void testWithInvalidInput() {
        // 0은 유효하지 않은 입력 값
        try {
            // 0은 유효하지 않은 입력 값이므로 예외가 발생해야 함
            Application.oneortwo(0);
            // 위의 코드가 예외를 발생시키지 않으면 테스트를 실패로 처리
            fail("예외가 발생되어야 한다");
        } catch (IllegalArgumentException e) {
            // 예외가 발생했으므로 테스트 통과
        }
    }

    @Test
    public void testWithInvalidInputString() {
        // q는 유효하지 않은 입력 값
        try {
            // 0은 유효하지 않은 입력 값이므로 예외가 발생해야 함
            Application.oneortwo(0);
            // 위의 코드가 예외를 발생시키지 않으면 테스트를 실패로 처리
            fail("예외가 발생되어야 한다");
        } catch (IllegalArgumentException e) {
            // 예외가 발생했으므로 테스트 통과
        }
    }

    @Test
    public void testWithValidInputOne() {
        // 1은 유효한 입력 값
        try {
            // 0은 유효하지 않은 입력 값이므로 예외가 발생해야 함
            Application.oneortwo(1);

        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 테스트 실패
            fail("예외가 발생하면 안 된다.");
        }
    }

    @Test
    public void testWithValidInputTwo() {
        // 2는 유효한 입력 값
        try {
            // 0은 유효하지 않은 입력 값이므로 예외가 발생해야 함
            Application.oneortwo(2);
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 테스트 실패
            fail("예외가 발생하면 안 된다.");
        }
    }
}