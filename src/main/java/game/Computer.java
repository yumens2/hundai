package game;

import java.util.List;

public class Computer {
    private final NumberGenerator numberGenerator;
    private List<Integer> numbers;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        numbers = numberGenerator.generateNumbers();
    }

    public Hint getHint(List<Integer> numbers) {
        int ball = 0, strike = 0;
        for(int i = 0; i < numbers.size(); i++) {
            int n = numbers.get(i);
            if(n == this.numbers.get(i)) {
                strike++;
            } else if(this.numbers.contains(n)) {
                ball++;
            }
        }
        return new Hint(strike, ball);
    }

    public void setNumbers() {
        numbers = numberGenerator.generateNumbers();
    }
}