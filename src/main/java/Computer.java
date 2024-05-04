import java.util.List;

public class Computer {

    private List<Integer> computerNumbers;

    // 랜덤한 숫자 3개 생성하는 함수
    public void generate() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        this.computerNumbers = randomNumberGenerator.generate();

    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
