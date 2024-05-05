package service;

import model.Game;
import utils.RandomUtil;

public class GameService {

    public void setGame() {
        Game game = new Game(RandomUtil.getRandomNumbers());
    }

}
