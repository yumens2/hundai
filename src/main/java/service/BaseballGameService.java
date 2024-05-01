package service;

import domain.Computer;
import dto.GameResultDTO;
import java.util.List;

public class BaseballGameService {
    public Computer computer;

    public void setNewGame(final int capacity, final List<Integer> computerValues){
        this.computer = new Computer(capacity, computerValues);
    }
}
