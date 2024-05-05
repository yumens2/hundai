public class Utils {

    /**
     * Get digits from number
     *
     * @param number number to get digits
     * @return int[] array of digits
     */
    public static int[] getDigits(int number) {
        int[] ret = new int[3];
        ret[0] = number / 100;
        ret[1] = number / 10 % 10;
        ret[2] = number % 10;
        return ret;
    }

    /**
     * Validate number for the game<br> Number must be between 100 and 999 and must not contain 0
     *
     * @param number number to validate
     * @throws IllegalArgumentException if number is not valid
     */
    public static void validateNumber(int number) {
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException("Number must be between 100 and 999");
        }
        int[] digits = getDigits(number);
        for (int digit : digits) {
            if (digit == 0) {
                throw new IllegalArgumentException("Number must not contain 0");
            }
        }
        if (digits[0] == digits[1] || digits[1] == digits[2] || digits[0] == digits[2]) {
            throw new IllegalArgumentException("Number must not contain duplicate digits");
        }
    }

    /**
     * Validate input string for the game<br> Input must be a number
     *
     * @param input input to validate
     * @return int number from input
     * @throws IllegalArgumentException if input is not a number
     */
    public static int InputToRightInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            validateNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a number");
        }
    }
}
