package problem;

public class StandardValueChecker implements ValueChecker{
    private final String problemValue;

    public StandardValueChecker(String problemValue) {
        this.problemValue = problemValue;
    }

    @Override
    public int determineTheValue(String inputValue) {
        int strike = 0;
        int ball = 0;

        String str ="";

        for (int i = 0; i < 3; i++) {
            if (this.problemValue.charAt(i) == inputValue.charAt(i)) {
                strike ++;
            }else if (problemValue.contains(String.valueOf(inputValue.charAt(i)))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            str = Message.NOTHING.toString();
        }else if (strike == 0){
            str = ball +" "+ Message.BALL.toString();
        } else if (ball == 0) {
            str = strike +" "+ Message.STRIKE.toString();
        }else
            str = strike +" "+ Message.STRIKE.toString() + " " + ball +" "+ Message.BALL.toString();

        System.out.println(str);

        if (strike == 3) {
            return 1;
        }
        return 0;
    }
}
