package baseball.service;

import baseball.parser.InputParser;
import baseball.validator.AnswerValidator;

public class GameService {

    public void play(String input) {
        AnswerValidator.validate(input);

        int answer = InputParser.parseAnswer(input);
    }
}
