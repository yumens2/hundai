package model;

import java.util.ArrayList;
import java.util.List;

public class User  {
    private List<Integer> numberList;

    public User() {
        numberList = new ArrayList<>();
    }

    public User setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
        return this;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
