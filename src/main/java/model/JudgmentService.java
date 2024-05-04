package model;

import java.util.ArrayList;

public class JudgmentService {
    public Score compare(ArrayList<Integer> targetNumbers, ArrayList<Integer> inputNumbers){
        return new Score(countStrike(targetNumbers,inputNumbers), countBall(targetNumbers,inputNumbers) - countStrike(targetNumbers,inputNumbers));
    }

    public int countStrike(ArrayList<Integer> targetNumbers, ArrayList<Integer> inputNumbers){
        int strikeCount = 0;
        for(int i = 0; i < inputNumbers.size(); i++){
            if(inputNumbers.get(i) == targetNumbers.get(i))
                strikeCount++;
        }
        return strikeCount;
    }

    public int countBall(ArrayList<Integer> targetNumbers, ArrayList<Integer> inputNumbers){
        int ballCount = 0;
        for(int i = 0; i < inputNumbers.size(); i++){
            if(targetNumbers.contains(inputNumbers.get(i)))
                ballCount++;
        }
        return ballCount;
    }
}
