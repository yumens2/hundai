package Entity;

import java.util.ArrayList;

public abstract class Player {
    final int INPUT_SIZE = 3;
    PlayerStatus playerStatus;
    ArrayList<BaseballStatus> baseballStatuses = new ArrayList<BaseballStatus>();
}
