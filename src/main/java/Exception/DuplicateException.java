package Exception;

public class DuplicateException extends IllegalArgumentException{

    public DuplicateException() {
        super("중복된 숫자입니다.");
    }
}
