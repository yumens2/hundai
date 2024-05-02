//import baseball.exception.InputException;
//import baseball.exception.RetryException;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class ExceptionTest {
//
//    private final InputException inputException = new InputException();
//    private final RetryException retryException = new RetryException();
//
//    @Test
//    public void inputValidation_ShouldThrowExceptionForInvalidLength() {
//
//        String input = "1234"; // 4자리 입력
//
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            inputException.isValidLength(input);
//        });
//    }
//
//    @Test
//    public void inputValidation_ShouldThrowExceptionForInvalidNumber() {
//
//        String input = "102"; // 숫자에 0 포함된 입력
//
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            inputException.isValidNumber(input);
//        });
//    }
//
//    @Test
//    public void inputValidation_ShouldThrowExceptionForDuplicateNumbers() {
//
//        String input = "112"; // 중복된 숫자가 포함된 입력
//
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            inputException.isDuplicatedNumber(input);
//        });
//    }
//
//    @Test
//    public void inputValidation_ShouldNotThrowExceptionForValidInput() {
//
//        String input = "456"; // 유효한 입력
//
//        Assertions.assertDoesNotThrow(() -> {
//            inputException.inputValidation(input);
//        });
//    }
//
//    @Test
//    public void retryValidation_ShouldThrowExceptionForInvalidLength() {
//        // Given
//        String input = "12"; // 2자리 입력
//
//        // When & Then
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            retryException.isValidLength(input);
//        });
//    }
//
//    @Test
//    public void retryValidation_ShouldThrowExceptionForInvalidNumber() {
//        // Given
//        String input = "3"; // 유효하지 않은 숫자 입력
//
//        // When & Then
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            retryException.isValidNumber(input);
//        });
//    }
//
//    @Test
//    public void RetryValidation_ShouldNotThrowExceptionForValidInput() {
//
//        String input = "1"; // 유효한 입력 (1 or 2)
//
//        Assertions.assertDoesNotThrow(() -> {
//            retryException.retryValidation(input);
//        });
//    }
//}
