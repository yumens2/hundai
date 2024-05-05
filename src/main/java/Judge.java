public class Judge {
    Compare compare = new Compare();
    public String Judgement(int[] computer, int[] player){
        int total = compare.countBallSum(computer, player);
        int strike = compare.countStrike(computer, player);
        int ball = total - strike;

        if(total == 0){
            return "아무것도 없어요!";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball+"볼" +strike +"스트라이크";


    }

}
