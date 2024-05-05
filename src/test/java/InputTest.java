import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @DisplayName("문자열을 포함하면 안 됨")
    @Test
    public void test1() {
        assertThat(Validation.isValidNum("12a")).isFalse();
        assertThat(Validation.isValidNum("abc")).isFalse();
        assertThat(Validation.isValidNum("123")).isTrue();
    }

    @DisplayName("3개의 수 이어야 함")
    @Test
    public void test2() {
        assertThat(Validation.isValidNum("1")).isFalse();
        assertThat(Validation.isValidNum("12")).isFalse();
        assertThat(Validation.isValidNum("123")).isTrue();
        assertThat(Validation.isValidNum("1234")).isFalse();
    }

    @DisplayName("0을 포함하면 안 됨")
    @Test
    public void test3() {
        assertThat(Validation.isValidNum("102")).isFalse();
        assertThat(Validation.isValidNum("012")).isFalse();
        assertThat(Validation.isValidNum("120")).isFalse();
        assertThat(Validation.isValidNum("123")).isTrue();
    }

    @DisplayName("중복된 수가 있으면 안 됨")
    @Test
    public void test4() {
        assertThat(Validation.isValidNum("111")).isFalse();
        assertThat(Validation.isValidNum("121")).isFalse();
        assertThat(Validation.isValidNum("122")).isFalse();
        assertThat(Validation.isValidNum("123")).isTrue();
    }

    @DisplayName("입력이 없으면 안 됨")
    @Test
    public void test5() {
        assertThat(Validation.isValidNum("")).isFalse();
        assertThat(Validation.isValidNum("123")).isTrue();
    }

    @DisplayName("종료 입력은 1 또는 2 이어야 함")
    @Test
    public void test6() {
        assertThat(Validation.isValidEnd("0")).isFalse();
        assertThat(Validation.isValidEnd("1")).isTrue();
        assertThat(Validation.isValidEnd("2")).isTrue();
        assertThat(Validation.isValidEnd("3")).isFalse();
        assertThat(Validation.isValidEnd("a")).isFalse();
    }
}
