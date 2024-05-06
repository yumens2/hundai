import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void checkThreeDigitNumber_rightInput_true() {
        assertTrue(Validation.checkThreeDigitNumber("136"));
        assertTrue(Validation.checkThreeDigitNumber("111"));
    }

    @Test
    void checkThreeDigitNumber_wrongLengthInput_false() {
        assertFalse(Validation.checkThreeDigitNumber("14"));
        assertFalse(Validation.checkThreeDigitNumber(""));
        assertFalse(Validation.checkThreeDigitNumber("6789"));
    }

    @Test
    void checkThreeDigitNumber_notNumberInput_false() {
        assertFalse(Validation.checkThreeDigitNumber("1a2"));
        assertFalse(Validation.checkThreeDigitNumber("14*"));
        assertFalse(Validation.checkThreeDigitNumber("9$0"));
    }

    @Test
    void checkDuplicateNumber_rightInput_true() {
        assertTrue(Validation.checkDuplicateNumber("136"));
        assertTrue(Validation.checkDuplicateNumber("567"));
    }

    @Test
    void checkDuplicateNumber_duplicateInput_false() {
        assertFalse(Validation.checkDuplicateNumber("118"));
        assertFalse(Validation.checkDuplicateNumber("399"));
        assertFalse(Validation.checkDuplicateNumber("080"));
    }

    @Test
    void checkEndCommand_rightInput_true() {
        assertTrue(Validation.checkEndCommand("1"));
        assertTrue(Validation.checkEndCommand("2"));
    }

    @Test
    void checkEndCommand_otherInput_false() {
        assertFalse(Validation.checkEndCommand("0"));
        assertFalse(Validation.checkEndCommand("a"));
        assertFalse(Validation.checkEndCommand("4"));
    }
}