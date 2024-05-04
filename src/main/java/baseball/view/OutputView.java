package baseball.view;

import baseball.dto.ResultDto;
import baseball.enums.Hint;

public class OutputView {

    public void result(ResultDto resultDto) {
        System.out.println(Hint.toString(resultDto));
    }

    public void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
