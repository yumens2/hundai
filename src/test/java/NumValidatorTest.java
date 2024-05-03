import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class NumValidatorTest {

//    @Test
//    public void testIsCorrectLength() {
//        String[] inputs = {"123", "1234", ""};
//        boolean[] expectedOutputs = {true, false, false};
//
//        for (int i = 0; i < inputs.length; i++) {
//            boolean actualOutput = NumValidator.isCorrectLength(inputs[i]);
//            assertEquals(expectedOutputs[i], actualOutput);
//        }
//    }

//    @Test
//    public void testIsOneToNine() {
//        String[] inputs = {"123"};
//        boolean[] expectedOutputs = {true};
//
//        for (int i = 0; i < inputs.length; i++) {
//            boolean actualOutput = NumValidator.isOneToNine(inputs[i]);
//            assertEquals(expectedOutputs[i], actualOutput);
//        }
//    }

    //    @Test
//    public void testIsNotDuplicateNum() {
//        String[] inputs = {"123", "1233", "132"};
//        boolean[] expectedOutputs = {true, false, true};
//
//        for (int i = 0; i < inputs.length; i++) {
//            boolean actualOutput = NumValidator.isNotDuplicateNum(inputs[i]);
//            assertEquals(expectedOutputs[i], actualOutput);
//        }
//    }
//
    @Test
    public void testIsValidInput() {
        String[] inputs = {"123", "1234", "012", "abc", "122", ""};
        boolean[] expectedOutputs = {true, false, false, false, false, false};

        for (int i = 0; i < inputs.length; i++) {
            boolean actualOutput = NumValidator.isValidInput(inputs[i]);
            assertEquals(expectedOutputs[i], actualOutput);
        }
    }
//
//    @Test
//    public void testIsOneOrTwo() {

//        String[] inputs = {"1", "2", "3", ""};
//        boolean[] expectedOutputs = {true, true, false, false};
//
//        for (int i = 0; i < inputs.length; i++) {
//            boolean actualOutput = NumValidator.isOneOrTwo(inputs[i]);
//            assertEquals(expectedOutputs[i], actualOutput);
//        }
//    }
}
