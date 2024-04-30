package exception;

public class InvalidLengthException extends IllegalArgumentException {
    public InvalidLengthException() {
        super("3자리의 숫자가 아닙니다.");
    }
}
