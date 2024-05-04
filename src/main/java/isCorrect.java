import java.util.HashSet;
import java.util.Set;

public class isCorrect {
    public boolean isThreeDigit(String inputValue){
        return inputValue.length() == 3;
    }

    public boolean isNum(String inputValue){
        try{
            Integer.parseInt(inputValue);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public boolean isUnique(String inputValue){
        Set<Character> characters = new HashSet<>();

       boolean isUnique = true;
       for (char c : inputValue.toCharArray()){
           if (!Character.isDigit(c) || characters.contains(c)) {
               isUnique = false;
               break;
           }
           characters.add(c);
       }

        return isUnique && characters.size() == 3;
    }

    public boolean isCorrectInput(String inputValue){

        if(!isThreeDigit(inputValue)){
            return false;
        } else if (!isNum(inputValue)) {
            return false;
        } else return isUnique(inputValue);
    }
}

