package baseball.service;

import baseball.parser.InputParser;
import baseball.validator.AnswerValidator;

public class GameService {

    public void play(String input) {
        try {
            AnswerValidator.validate(input);
        } catch (IllegalArgumentException e) {
            return; // todo:
        }

        int answer = InputParser.parseAnswer(input);
    }
}
