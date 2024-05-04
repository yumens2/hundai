import java.util.List;
import java.util.stream.IntStream;

public class Referee {

    // 컴퓨터 숫자와 플레이어 숫자를 비교해서 정보를 알려주는 함수
    public JudgeDTO judge(List<Integer> playerBalls, List<Integer> computerBalls) {
        int strikeCount = countStrikes(playerBalls, computerBalls);
        int ballCount = countBalls(playerBalls, computerBalls);

        return new JudgeDTO(strikeCount, ballCount);
    }

    private int countStrikes(List<Integer> playerBalls, List<Integer> computerBalls) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (playerBalls.get(i).equals(computerBalls.get(i))) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private int countBalls(List<Integer> playerBalls, List<Integer> computerBalls) {
        return (int) IntStream.range(0, computerBalls.size())
            .filter(i -> !playerBalls.get(i).equals(computerBalls.get(i))) // 같은 위치가 아닌 경우
            .filter(
                i -> computerBalls.contains(playerBalls.get(i))) // answer 리스트에 guess의 요소가 존재하는 경우
            .count(); // 조건을 만족하는 요소의 개수, 즉 볼의 개수를 계산
    }
}
