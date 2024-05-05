package camp.nextstep.edu.application.core;

import java.util.Random;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

    private final Random random = new Random();

    @Override
    public int nextInt(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    @Override
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
