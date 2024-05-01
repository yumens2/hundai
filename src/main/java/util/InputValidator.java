package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateHumanValues(String input) {
        integerTypeCheck(input);
        inputIsDuplicated(input);
    }

    private static void integerTypeCheck(String input){
        if(!input.matches("[1-9]+")){
            throw new IllegalArgumentException("Input Type이 [1-9] 사이의 숫자가 아닙니다.");
        }
    }

    private static void inputIsDuplicated(String input){
        Set<String> components = new HashSet<>(List.of(input.split("")));
        if(components.size() != input.length()){
            throw new IllegalArgumentException("Input 값 중 중복값이 존재합니다.");
        }
    }
}
