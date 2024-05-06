package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("자리 수 확인")
    void testIsValidateDigitCount() {
        assertThatThrownBy(() -> inputView.inputValidation("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정수 확인")
    void testIsValidateInt() {
        assertThatThrownBy(() -> inputView.inputValidation("12a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}