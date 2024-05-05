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
            return Message.NOTHING.toString();
        }else if (strike == 0){
            return ball +" "+ Message.BALL.toString();
        } else if (ball == 0) {
            return strike +" "+ Message.STRIKE.toString();
        }else
            return strike +" "+ Message.STRIKE.toString() + " " + strike +" "+ Message.STRIKE.toString();
    }
}
