import java.util.List;

public class Computer {
    private final NumberGenerator numberGenerator;
    private final List<Integer> numbers;

    public Computer() {
        this.numberGenerator = new RandomNumberGenerator();
        this.numbers = numberGenerator.generateNumbers();
    }
}