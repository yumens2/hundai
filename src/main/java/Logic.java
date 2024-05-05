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
        this.init();
    }

    /**
     * Constructor for Logic class Used for testing or need to set computer number manually
     *
     * @param computerNumber answer of the games
     */
    Logic(int computerNumber) {
        this.setComputerNumber(computerNumber);
    }

    public void init() {
        while (true) {
            this.setComputerNumber((int) (Math.random() * 900) + 100);
            try {
                Utils.validateNumber(computerNumber);
                break;
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    /**
     * Set computer number manually Used for testing or need to set computer number manually
     *
     * @param computerNumber answer of the game
     */
    public void setComputerNumber(int computerNumber) {
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
        }

        for (int i = 0; i < 3; i++) {
            if (freq[userDigits[i]] > 0 && (computerDigits[i] != userDigits[i])) {
                ball_count++;
                freq[userDigits[i]]--;
            }
        }

        return ball_count;
    }

    public int getComputerNumber() {
        return computerNumber;
    }

    public int[] getComputerDigits() {
        return computerDigits;
    }
}