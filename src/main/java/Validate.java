public class Validate {
    public Boolean numberValidate(String input) {
        if (input == null) {
            return Boolean.FALSE;
        }
        if (input.length() != 3) {
            return Boolean.FALSE;
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
