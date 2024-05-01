package enums;

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
        return this.count + " " + this.judgement;
    }
}
