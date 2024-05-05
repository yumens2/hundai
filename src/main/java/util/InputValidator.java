package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateHumanValues(String input) {
        humanValueTypeCheck(input);
        inputIsDuplicated(input);
    }

    public static void validateGameType(String input){
        integerTypeCheck(input);
    }

    private static void humanValueTypeCheck(String input){
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

    private static void integerTypeCheck(String input){
        if(!input.matches("[-]?[0-9]+")){
            throw new IllegalArgumentException("게임 시작 메뉴 입력이 숫자형이 아닙니다.");
        }
    }
}
