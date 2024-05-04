package Exception;

public class InvalidInputException extends IllegalArgumentException{

    public InvalidInputException() {
        super("숫자를 입력해주세요.");
    }
}
