package controller;

import dto.GameResultDTO;
import java.util.List;
import service.BaseballGameService;
import view.InputView;
import view.OutputView;

public class BaseballController {
    private final BaseballGameService baseballGameService;

    public BaseballController() {
        this.baseballGameService = new BaseballGameService();
    }

    public void setNewGame(final int capacity, final List<Integer> computerValues){
        baseballGameService.setNewGame(capacity, computerValues);
    }
    public int run(){
        GameResultDTO gameResultDTO;
        do{
            List<Integer> humanInput = InputView.printInputRequest();
            gameResultDTO = baseballGameService.compareNumber(humanInput);
            OutputView.printResult(gameResultDTO);
        }while(!gameResultDTO.gameEnded());

        OutputView.printEndGame();
        return InputView.printRestartRequest();
    }
}
