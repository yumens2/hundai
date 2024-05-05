public class ResultPrint {
    public String judge(int contain, int strike){
        int ball = 0;

        if (contain > 0){
            ball = contain - strike;
        }

        if (contain == 0){
            return "낫싱";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else if (strike == 0) {
            return contain + "볼";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }
}
