/**
 * Logic class for the game
 */
public class Logic {

    private int computerNumber;
    private int[] computerDigits;

    /**
     * Constructor for Logic class
     */
    Logic() {
        this.computerNumber = (int) (Math.random() * 1000);
        this.computerDigits = Utils.getDigits(computerNumber);
    }

    /**
     * Constructor for Logic class Used for testing or need to set computer number manually
     *
     * @param computerNumber answer of the game
     */
    Logic(int computerNumber) {
        this.setComputerNumber(computerNumber);
    }

    /**
     * Set computer number manually Used for testing or need to set computer number manually
     *
     * @param computerNumber answer of the game
     */
    public void setComputerNumber(int computerNumber) {
//        System.out.println("Warning : This method is for testing only. Do not use in production.");
        this.computerNumber = computerNumber;
        this.computerDigits = Utils.getDigits(computerNumber);
    }

    /**
     * Returns the count of digits from the user's number that match the computer's number and are
     * in the correct position.
     *
     * @param userNumber user input number
     * @return The count of digits that match method's condition
     */
    public int isStrike(int userNumber) {
        int[] user_digits = Utils.getDigits(userNumber);
        int strike_count = 0;
        for (int i = 0; i < 3; i++) {
            if (user_digits[i] == computerDigits[i]) {
                strike_count++;
            }
        }
        return strike_count;
    }

    /**
     * If user number is not match anything with computer number return true
     *
     * @param userNumber user input number
     * @return if user number is not match anything with computer number return true
     */
    public boolean isNothing(int userNumber) {
        int[] user_digits = Utils.getDigits(userNumber);
        for (int i = 0; i < 3; i++) {
            if (user_digits[i] == computerDigits[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the count of digits from the user's number that match the computer's number but are
     * in the incorrect position.
     *
     * @param userNumber user input number
     * @return The count of digits that match method's condition
     */
    public int isBall(int userNumber) {
        int[] userDigits = Utils.getDigits(userNumber);
        int[] freq = new int[10];
        int ball_count = 0;

        for (int i = 0; i < 3; i++) {
            freq[computerDigits[i]]++;
            freq[userDigits[i]]++;
        }

        for (int i = 0; i < 3; i++) {
            if (freq[userDigits[i]] > 1 && (computerDigits[i] != userDigits[i])) {
                ball_count++;
            }
        }

        return ball_count;
    }

    public boolean isWin(int userNumber) {
        return isStrike(userNumber) == 3;
    }

    public int getComputerNumber() {
        return computerNumber;
    }
}