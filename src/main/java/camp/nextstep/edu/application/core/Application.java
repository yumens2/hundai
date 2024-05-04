package camp.nextstep.edu.application.core;

import camp.nextstep.edu.global.InputDispatcherListener;

public class Application {

    private static final InputDispatcherListener dispatcher = new InputDispatcherListener();
    private static final NumberBaseballGameConfig config = new NumberBaseballGameConfig();

    public static void main(String[] args) {
        NumberBaseballGame game = config.numberBaseballGame();
        game.run();

        dispatcher.addListener(config.inputListener());
        dispatcher.run();
    }
}
