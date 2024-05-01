package service;

import domain.Computer;
import dto.GameResultDTO;
import java.util.List;

public class BaseballGameService {
    public Computer computer;

    public void setNewGame(final int capacity, final List<Integer> computerValues){
        this.computer = new Computer(capacity, computerValues);
    }

    public GameResultDTO compareNumber(final List<Integer> humanValues){
        return new GameResultDTO(
                computer.getCapacity(),
                computer.countStrike(humanValues),
                computer.countBall(humanValues)
        );
    }
}
