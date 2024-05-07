package baseball.domain;

public class GameRules {
    public String generateHint(String secretNumber, String userGuess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userGuess.charAt(i) == secretNumber.charAt(i)) {
                strike++;
            } else if (secretNumber.contains(userGuess.substring(i, i+1))) {
                ball++;
            }
        }
        return createHintMessage(strike, ball);
    }

    private String createHintMessage(int strike, int ball) {
        String result = "";
        if (strike == 0 && ball == 0) {
            result = "낫싱";
        } else {
            if (ball > 0) {
                result += ball + "볼 ";
            }
            if (strike > 0) {
                result += strike + "스트라이크";
            }
        }
        return result.trim();
    }

    public Boolean decideRestart(String input) {
        switch (input) {
            case "1":
                return true;
            case "2":
                return false;
            default:
                return null;
        }
    }
}
