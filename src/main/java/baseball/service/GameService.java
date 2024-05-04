package baseball.service;

import baseball.dto.ResultDto;
import baseball.model.Computer;
import baseball.parser.InputParser;
import baseball.validator.AnswerValidator;
import baseball.validator.BitValidator;
import java.util.List;

public class GameService {

    private final Computer computer;

    public GameService() {
        computer = new Computer();
    }

    public ResultDto play(String input) {
        AnswerValidator.validate(input);
        List<Integer> answer = InputParser.parseAnswer(input);

        return computer.judge(answer);
    }

    public boolean isCorrect(ResultDto resultDto) {
        return resultDto.getStrike() == 3 && resultDto.getBall() == 0;
    }

    public boolean restart(String input) {
        BitValidator.validate(input);
        int bit = InputParser.parseBit(input);

        return bit == 1;
    }
}
