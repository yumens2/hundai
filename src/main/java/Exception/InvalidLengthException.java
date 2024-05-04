package Exception;

public class InvalidLengthException extends IllegalArgumentException{

    public InvalidLengthException() {
        super("세 자리 수를 입력해주세요.");
    }
}
