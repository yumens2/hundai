package enums;

/**
 * Judgement는 스트라이크, 볼, 낫싱을 나타내는 열거형입니다.
 */
public enum Judgement {
    STRIKE("스트라이크", 0),
    BALL("볼", 0),
    NOTHING("낫싱", 0);

    private final String judgement;
    private Integer count;

    Judgement(String judgement, Integer count) {
        this.judgement = judgement;
    }

    public String getJudgement() {
        return judgement;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String toString() {
        if(judgement.equals("낫싱"))
            return this.judgement;

        return this.count + this.judgement;
    }
}
