import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidateTest {
    private Validate validate = new Validate();
    @Test
    public void 모든_입력이_세_자리수_숫자() {
        String input = "123";
        assertTrue(validate.numberValidate(input));
    }

    @Test
    public void 입력_값에_0이_들어감() {
        String input = "012";
        assertFalse(validate.numberValidate(input));
    }

    @Test
    public void 모든_입력이_숫자_세_글자는_아님() {
        String input = "123879595";
        assertFalse(validate.numberValidate(input));
    }

    @Test
    public void 모든_자리가_숫자는_아님() {
        String input = "313sft4904";
        assertFalse(validate.numberValidate(input));
    }

    @Test
    public void 모두_숫자가_아님() {
        String input = "asd";
        assertFalse(validate.numberValidate(input));
    }

    @Test
    public void 빈_문자열() {
        String input = "";
        assertFalse(validate.numberValidate(input));
    }

    @Test
    public void 입력_값이_null() {
        String input = null;
        assertFalse(validate.numberValidate(input));
    }

    @Test
    public void 중복_값() {
        String input = "122";
        assertFalse(validate.numberValidate(input));
    }

    @Test
    public void 입력_값이_0인_경우() {
        String input = "1";
        assertTrue(validate.yesOrNoValidate(input));
    }

    @Test
    public void 입력_값이_1인_경우() {
        String input = "1";
        assertTrue(validate.yesOrNoValidate(input));
    }

    @Test
    public void 입력_값이_0_또는_1이_아닌_경우() {
        String input = "a";
        assertFalse(validate.yesOrNoValidate(input));
    }

    @Test
    public void 입력_값이_null_인_경우() {
        String input = null;
        assertFalse(validate.yesOrNoValidate(input));
    }
}