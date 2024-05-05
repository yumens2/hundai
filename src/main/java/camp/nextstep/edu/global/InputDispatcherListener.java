package camp.nextstep.edu.global;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputDispatcherListener implements InputListener {

    private Scanner scanner;
    private final List<InputListener> listeners = new LinkedList<>();
    private boolean running = false;

    public void run() {
        scanner = new Scanner(System.in);
        running = true;
        while (running) {
            if(!ready()) {
                stop();
                break;
            }
            String input = scanner.nextLine();
            InputSubmitFlag result = onInputSubmitted(input);
            if(result == InputSubmitFlag.CLOSE_SUBMITTING_INPUT) {
                stop();
            }
        }
    }

    public void addListener(InputListener listener) {
        listeners.add(listener);
    }

    public void stop() {
        running = false;
        scanner.close();
    }

    @Override
    public boolean ready() {
        return readyAll();
    }

    @Override
    public InputSubmitFlag onInputSubmitted(String input) {
        boolean endFlag = false;
        for(InputListener listener : listeners) {
            InputSubmitFlag result = listener.onInputSubmitted(input);
            if(result == InputSubmitFlag.CLOSE_SUBMITTING_INPUT) {
                endFlag = true;
            }
        }
        if(endFlag) {
            return InputSubmitFlag.CLOSE_SUBMITTING_INPUT;
        }
        return InputSubmitFlag.CONTINUE;
    }

    private boolean readyAll() {
        boolean isReady = true;
        for(InputListener listener : listeners) {
            boolean result = listener.ready();
            if(!result) {
                isReady = false;
            }
        }
        return isReady;
    }
}
