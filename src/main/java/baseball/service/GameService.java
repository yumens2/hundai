package baseball.service;

import baseball.model.Computer;
import baseball.parser.InputParser;
import baseball.validator.AnswerValidator;

public class GameService {

    private final Computer computer;

    public GameService() {
        computer = new Computer();
    }

    public void play(String input) {
        computer.init();

        AnswerValidator.validate(input);
        int answer = InputParser.parseAnswer(input);
    }
}
