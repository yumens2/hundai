package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationUtilTest {

    @DisplayName("[세 자리 수인 경우] 세 자리 수인지 체크한다.")
    @Test
    void isThreeDigitsWithThreeDigits() throws Exception {
        //given
        int num = 123;

        //when & then
        ValidationUtil.isThreeDigits(num);
    }

    @DisplayName("[세 자리 수가 아닌 경우] 세 자리 수인지 체크한다.")
    @Test
    void isThreeDigitsWithoutThreeDigits() throws Exception {
        //given
        int num = 1234;

        //when & then
        Assertions.assertThatThrownBy(() -> ValidationUtil.isThreeDigits(num))
            .isInstanceOf(IllegalArgumentException.class);
    }

}