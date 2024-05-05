package baseball.dto;


import baseball.Validator;

public class RestartRequest {
    boolean isRestart;

    private RestartRequest(boolean isRestart) {
        this.isRestart = isRestart;
    }

    public boolean isRestart() {
        return isRestart;
    }

    public static RestartRequest of(String userInput) {
        Validator.validIsInteger(userInput);
        int num = Integer.parseInt(userInput);
        Validator.validRestartNum(num);
        if (num == 1) {
            return new RestartRequest(true);
        }
        return new RestartRequest(false);
    }
}
