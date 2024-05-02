package baseball.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {
    private static final int VALID_LENGTH =3;

    public void inputValidation(String input){
        isValidNumber(input);
        isDuplicatedNumber(input);
        isValidLength(input);

    }

    public void isValidLength(String input){
        if(input.length()!=VALID_LENGTH) throw new IllegalArgumentException("3자리 숫자만 입력 가능");
    }

    public void isValidNumber(String input){
        if(input.contains("0")) throw new IllegalArgumentException("숫자에 0 포함 불가능");
    }

    public void isDuplicatedNumber(String input){
        Set<Character> set = new HashSet<>();
        for(int i=0;i<input.length();i++){
            set.add(input.charAt(i));
        }
        if(set.size()!=VALID_LENGTH) throw new IllegalArgumentException("중복 숫자 입력 불가능");
    }

}
