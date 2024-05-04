public class Validator {
    public boolean isUserInputValid(String userInput){
        if (!isUserInputLengthGameNum(userInput)){
            return false;
        }

        if (!isUserInputNotInt(userInput)){
            return false;
        }

        return isUserInputNotSame(userInput);
    }

    private boolean isUserInputLengthGameNum(String userInput){
        return (userInput != null && userInput.length() == 3);
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
