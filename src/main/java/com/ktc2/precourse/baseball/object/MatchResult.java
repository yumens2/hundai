package com.ktc2.precourse.baseball.object;

/**
 * 매칭 결과를 표현하는 클래스
 */
public class MatchResult {
    private final int strike;
    private final int ball;

    public MatchResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        String ret = "";
        if (strike > 0) {
            ret += strike + " 스트라이크 ";
        }
        if (ball > 0) {
            ret += ball + " 볼 ";
        }
        if (isNothing()) {
            ret = "낫싱";
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchResult)) {
            return false;
        }

        MatchResult r = (MatchResult) obj;
        if (this.ball != r.ball) {
            return false;
        }
        if (this.strike != r.strike) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 10 * strike + ball;
    }

    /**
     * 모두 스트라이크인지 확인
     * @return 모두 스트라이크이면 true
     */
    public boolean isAllStrike() {
        return strike == Numbers.LENGTH;
    }

    /**
     * 낫싱인지 확인
     * @return 낫싱이면 true
     */
    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
