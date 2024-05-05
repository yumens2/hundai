package numberbaseballgame;

public class GameNumber {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public GameNumber() {
    }

    public GameNumber(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    public GameNumber(int number) {
        this.thirdNumber = number % 10;
        number = number / 10;
        this.secondNumber = number % 10;
        this.firstNumber = number / 10;
    }

    public int getFirstNumber() {
        return this.firstNumber;
    }

    public int getSecondNumber() {
        return this.secondNumber;
    }

    public int getThirdNumber() {
        return this.thirdNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setThirdNumber(int thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

    public void setGameNumber(int firstNumber, int secondNumber, int thirdNumber) {
        setFirstNumber(firstNumber);
        setSecondNumber(secondNumber);
        setThirdNumber(thirdNumber);
    }

    public void setGameNumber(int number) {
        setThirdNumber(number % 10);
        number = number / 10;
        setSecondNumber(number % 10);
        setFirstNumber(number / 10);
    }

    public boolean equals(GameNumber gameNumber) {
        return (this.firstNumber == gameNumber.firstNumber) &&
            (this.secondNumber == gameNumber.secondNumber) &&
            (this.thirdNumber == gameNumber.thirdNumber);
    }

    public boolean isNumberInRange() {
        if (MINIMUM_NUMBER <= firstNumber && firstNumber <= MAXIMUM_NUMBER &&
            MINIMUM_NUMBER <= secondNumber && secondNumber <= MAXIMUM_NUMBER &&
            MINIMUM_NUMBER <= thirdNumber && thirdNumber <= MAXIMUM_NUMBER) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNumberUnique() {
        if (firstNumber == secondNumber ||
            firstNumber == thirdNumber ||
            secondNumber == thirdNumber) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        return firstNumber + ", " + secondNumber + ", " + thirdNumber;
    }
}