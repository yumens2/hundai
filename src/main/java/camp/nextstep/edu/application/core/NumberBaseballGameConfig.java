package camp.nextstep.edu.application.core;

import camp.nextstep.edu.application.presenter.DefaultBaseballGameInputListener;
import camp.nextstep.edu.global.InputListener;

public class NumberBaseballGameConfig {

    private static final RandomNumberGenerator randomNumberGenerator =
            new RandomNumberGeneratorImpl();
    private static final InputValueValidationStrategy inputValueValidationStrategy =
            new DefaultInputValueValidationStrategy();
    private static final DefenseResultMatcher defenseResultMatcher =
            new DefenseResultMatcherImpl();

    public NumberBaseballGame createNumberBaseballGame() {
        return new NumberBaseballGame(
                inputValueValidationStrategy,
                randomNumberGenerator,
                defenseResultMatcher
        );
    }

    public InputListener createInputListener(NumberBaseballGame numberBaseballGame) {
        return new DefaultBaseballGameInputListener(numberBaseballGame);
    }
}
