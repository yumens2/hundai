public class Computer {

    private String computerNumber;

    public void setComputerNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        this.computerNumber = randomNumberGenerator.getRandomNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }
}
