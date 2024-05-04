package Model;
public class InputValidator {
    public static boolean isValid(String input) {
        if (input.length() != 3) return false;
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) || ch == '0') return false;
        }
        return input.charAt(0) != input.charAt(1) && input.charAt(0) != input.charAt(2) && input.charAt(1) != input.charAt(2);
    }
}
