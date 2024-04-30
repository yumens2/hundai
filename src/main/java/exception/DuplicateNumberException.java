package exception;

public class DuplicateNumberException extends IllegalArgumentException {
    public DuplicateNumberException() {
        super("중복된 숫자가 입력되었습니다.");
    }
}
