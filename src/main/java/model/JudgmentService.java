package model;

import java.util.ArrayList;

public class JudgmentService {
    public Score compare(ArrayList<Integer> targetNumbers, ArrayList<Integer> inputNumbers){
        return new Score(countStrike(targetNumbers,inputNumbers), countBall(targetNumbers,inputNumbers));
    }

    public int countStrike(ArrayList<Integer> targetNumbers, ArrayList<Integer> inputNumbers){

    }

    public int countBall(ArrayList<Integer> targetNumbers, ArrayList<Integer> inputNumbers){

    }
}
