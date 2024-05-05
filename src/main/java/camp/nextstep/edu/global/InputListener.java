package camp.nextstep.edu.global;

public interface InputListener {

    boolean ready();

    InputSubmitFlag onInputSubmitted(String input);

}