package camp.nextstep.edu.application.presenter;

import camp.nextstep.edu.global.InputSubmitFlag;
import camp.nextstep.edu.application.core.NumberBaseballGame;
import camp.nextstep.edu.global.InputListener;

public class DefaultBaseballGameInputListener implements InputListener {

    private final NumberBaseballGame game;

    public DefaultBaseballGameInputListener(NumberBaseballGame game) {
        this.game = game;
    }

    @Override
    public boolean ready() {
        return game.isRunning();
    }

    @Override
    public InputSubmitFlag onInputSubmitted(String input) {
        try {
            game.onInputSubmitted(input);
        } catch (IllegalStateException e) {
            return InputSubmitFlag.CLOSE_SUBMITTING_INPUT;
        }
        return InputSubmitFlag.CONTINUE;
    }
}
