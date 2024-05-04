public class Validator {
    private boolean isUserInputLengthGameNum(String userInput){
        return (userInput != null && userInput.length() == 3);
    }
}
