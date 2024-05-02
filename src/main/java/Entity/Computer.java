package Entity;

import java.util.*;

public class Computer extends Player {
    private Set<Integer> numberSet;

    public Computer() {
        numberSet = new LinkedHashSet<>();
        playerStatus = PlayerStatus.COMPUTER;
    }

    public Computer setNumberSet(Set<Integer> numberSet) {
        this.numberSet = numberSet;
        return this;
    }

    public Set<Integer> getNumberSet() {
        return numberSet;
    }
}
