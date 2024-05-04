public class Validator {
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
}
