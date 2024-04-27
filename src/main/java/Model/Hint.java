package Model;

public class Hint {
    //정보은닉
    private int ball;//수는 같지만 다른자리
    private int strike;//같은자리 같은수
    public Hint(int ball, int strike){//생성자로 초기화
        this.ball = ball;
        this.strike = strike;
    }
    //값만 확인할 수 있게 getter사용
    public int getBall() {
        return ball;
    }
    public int getStrike() {//strike
        return strike;
    }



}
