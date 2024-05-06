package model;

import java.util.*;

public class Computer {
    private Set<Integer> numberSet;

    public Computer() {
        numberSet = new LinkedHashSet<>();
    }

    public Computer setNumberSet(Set<Integer> numberSet) {
        this.numberSet = numberSet;
        return this;
    }

    public Set<Integer> getNumberSet() {
        return numberSet;
    }
}
