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

    public int getComputerNumber() {
        return computerNumber;
    }
}