package camp.nextstep.edu.application.core;

import java.util.List;

public class DefenseResultMatcherImpl implements DefenseResultMatcher {

    @Override
    public DefenseResult match(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        return new DefenseResult(strike, ball);
    }
}
