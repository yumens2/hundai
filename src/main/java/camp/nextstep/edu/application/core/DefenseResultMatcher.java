package camp.nextstep.edu.application.core;

import java.util.List;

public interface DefenseResultMatcher {

    DefenseResult match(List<Integer> computerNumbers, List<Integer> playerNumbers);

}
