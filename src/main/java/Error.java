import java.util.Set;
import java.util.HashSet;

public class Error {
    public static int detectError(String userNum) {
        try {
            if (userNum.length() != 3 | isValidData(userNum)) throw new IllegalArgumentException("1~9까지의 3자리 자연수를 입력해주세요.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 2;
        }
        return 1;
    }
    public static boolean isValidData(String userNum) {
        Set<Integer> numSet = new HashSet<Integer>();
        int temp;

        for (int i = 0; i < userNum.length(); i++) {
            temp = userNum.charAt(i);
            if ( 48 > temp | temp > 57) return true;
            numSet.add(temp);
        }

        if (numSet.size() != 3) return true;
        return false;
    }
}
