package Exception;

public class ContainZeroException extends IllegalArgumentException{

    public ContainZeroException() {
        super("1~9 사이의 값을 입력해주세요.");
    }
}
