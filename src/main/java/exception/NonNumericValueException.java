package exception;

public class NonNumericValueException extends IllegalArgumentException {
    public NonNumericValueException() {
        super("1~9까지의 숫자가 아닙니다.");
    }
}
