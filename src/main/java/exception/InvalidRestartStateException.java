package exception;

public class InvalidRestartStateException extends IllegalArgumentException {
    public InvalidRestartStateException() {
        super("1 또는 2가 아닙니다.");
    }
}
