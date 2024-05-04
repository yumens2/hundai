package numberbaseball;

public class GameNumber {

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    private GameNumber() {
    }

    public GameNumber(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    public boolean areNumbersInRange() {
        if (MINIMUM_NUMBER <= firstNumber && firstNumber <= MAXIMUM_NUMBER &&
            MINIMUM_NUMBER <= secondNumber && secondNumber <= MAXIMUM_NUMBER &&
            MINIMUM_NUMBER <= thirdNumber && thirdNumber <= MAXIMUM_NUMBER) {
            return true;
        } else {
            return false;
        }
    }

    public boolean areNumbersUnique() {
        if (firstNumber == secondNumber ||
            firstNumber == thirdNumber ||
            secondNumber == thirdNumber) {
            return false;
        } else {
            return true;
        }
    }
}