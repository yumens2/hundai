package precourse.player;

import precourse.game.NumberBaseBall;
import precourse.input.InputManager;

public class Player {
    private final InputManager inputManager;
    private final NumberBaseBall numberBaseBall;

    public Player(InputManager inputManager, NumberBaseBall numberBaseBall) {
        this.inputManager = inputManager;
        this.numberBaseBall = numberBaseBall;
    }

    public void playNumberBaseBall(){
        do{
            numberBaseBall.startRound(3);
            do{
                numberBaseBall.playTurn(inputManager.readLine());
            }while(!numberBaseBall.isRoundEnded());
            numberBaseBall.enterEndCommand(inputManager.readLine());
        }while (!numberBaseBall.isNotStarted());
    }

}
