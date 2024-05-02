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
}
