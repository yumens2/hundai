import java.util.ArrayList;
import java.util.List;

public class PlayBall implements Play {

    @Override
    public List<Integer> baseBall(int number, int answer) {
        List<Integer> result = new ArrayList<>();
        String numberToStr = Integer.toString(number);
        String answerToStr = Integer.toString(answer);
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < numberToStr.length(); i++) {
            char numberChar = numberToStr.charAt(i);
            for (int j = 0; j < answerToStr.length(); j++) {
                char answerChar = answerToStr.charAt(j);
                if (i == j && numberChar == answerChar) {
                    strikeCount += 1;
                } else if (i != j && numberChar == answerChar) {
                    ballCount += 1;
                }
            }
        }
        result.add(ballCount);
        result.add(strikeCount);
        return result;
    }
}
