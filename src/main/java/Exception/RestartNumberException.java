package Exception;

public class RestartNumberException extends IllegalArgumentException{

    public RestartNumberException() {
        super("1 또는 2를 입력해주세요.");
    }
}
