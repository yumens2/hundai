public class Validator {
    public boolean isUserInputValid(String userInput){
        if (!isUserInputLength(userInput, GameNum.GAME_NUM.getGameNum())){
            return false;
        }

        if (!isUserInputNotInt(userInput)){
            return false;
        }

        return isUserInputNotSame(userInput);
    }
    public boolean isRestartInputValid(String restartInput){
        if (!isUserInputNotInt(restartInput)){
            return false;
        }
        if (!isUserInputLength(restartInput, 1)){
            return false;
        }
        return restartInput.equals("1") || restartInput.equals("2");
    }
    private boolean isUserInputLength(String userInput, int inputLength){
        return (userInput != null && userInput.length() == inputLength);
    }

    private boolean isUserInputNotInt(String userInput){
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUserInputNotSame(String userInput){
        return (userInput.charAt(0) != userInput.charAt(1) &&
            userInput.charAt(0) != userInput.charAt(2) &&
            userInput.charAt(1) != userInput.charAt(2));
    }
}
