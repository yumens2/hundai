package baseball;

public class PlayBaseball {

    public static void main(String[] args) {
        BaseballGame baseball = new BaseballGame();
        try{
            baseball.playBaseballGame();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 수를 입력하였습니다.");
        }

    }
}
