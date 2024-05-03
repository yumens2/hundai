import java.util.List;

public class Referee {

    public String compare(List<Integer> computer, List<Integer> player) {
        Judgement judgement = new Judgement();
        int matchNumber = judgement.matchNumber(computer, player);

        int strike = 0;
        for (int placeNumber = 0; placeNumber < player.size(); placeNumber++) {
            if (judgement.placeCheck(computer, placeNumber, player.get(placeNumber))) {
                strike++;
            }
        }

        int ball = matchNumber - strike;

        if (matchNumber == 0) {
            return "낫싱";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }
}
