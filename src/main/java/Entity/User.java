package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Player {
    private List<Integer> numberList;

    public User() {
        numberList = new ArrayList<>();
        playerStatus = PlayerStatus.PERSON;
    }

    public User setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
        return this;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
