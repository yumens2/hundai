package precourse.utils;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {
    public static boolean isEachCharUnique(String str){
        Set<Character> characters = new HashSet<>();
        for(Character c : str.toCharArray()){
            if (!characters.add(c)) return false;
        }
        return true;
    }
    private StringUtil(){}
}
