package src.main.java.problem;

public class StandardValueChecker implements ValueChecker{
    private final String problemValue;

    public StandardValueChecker(String problemValue) {
        this.problemValue = problemValue;
    }

    @Override
    public String determineTheValue(String inputValue) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (this.problemValue.charAt(i) == inputValue.charAt(i)) {
                strike ++;
            }else if (problemValue.contains(String.valueOf(inputValue.charAt(i)))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            return ProvidedMessage.NOTHING.toString();
        }else if (strike == 0){
            return ball +" "+ ProvidedMessage.BALL.toString();
        } else if (ball == 0) {
            return strike +" "+ ProvidedMessage.STRIKE.toString();
        }else
            return strike +" "+ ProvidedMessage.STRIKE.toString() + " " + strike +" "+ ProvidedMessage.STRIKE.toString();
    }
}
