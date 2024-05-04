package camp.nextstep.edu.application.core;

import camp.nextstep.edu.application.presenter.DefaultBaseballGameInputListener;
import camp.nextstep.edu.global.InputListener;

public class NumberBaseballGameConfig {

    private static final RandomNumberGenerator randomNumberGenerator =
            new RandomNumberGeneratorImpl();
    private static final InputValueValidationStrategy inputValueValidationStrategy =
            new DefaultInputValueValidationStrategy();

    private static final NumberBaseballGame numberBaseballGame =
            new NumberBaseballGame(
                    inputValueValidationStrategy,
                    randomNumberGenerator
            );

    private static final InputListener inputListener =
            new DefaultBaseballGameInputListener(numberBaseballGame);

    public NumberBaseballGame numberBaseballGame() {
        return numberBaseballGame;
    }

    public InputListener inputListener() {
        return inputListener;
    }
}
