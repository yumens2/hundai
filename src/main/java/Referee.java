import java.util.List;

public class Referee {
    /**
     * 스트라이크와 볼을 리턴하는 메소드
     * @param computerNumbers 컴퓨터가 생성한 숫자 리스트
     * @param playerNumbers 사용자가 입력한 숫자 리스트
     * @return 스트라이크와 볼 개수를 담은 배열
     */
    public int[] determineResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikes = countStrikes(computerNumbers, playerNumbers);
        int balls = countBalls(computerNumbers, playerNumbers, strikes);
        return new int[]{strikes, balls};
    }
    /**
     * 스트라이크 개수를 계산하는 메소드
     * @param computerNumbers 컴퓨터가 생성한 숫자 리스트
     * @param playerNumbers 사용자가 입력한 숫자 리스트
     * @return 스트라이크 개수
     */
    private int countStrikes(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikes = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    /**
     * 볼 개수를 계산하는 메소드
     * @param computerNumbers 컴퓨터가 생성한 숫자 리스트
     * @param playerNumbers 사용자가 입력한 숫자 리스트
     * @param strikes 스트라이크 개수
     * @return 볼 개수
     */
    private int countBalls(List<Integer> computerNumbers, List<Integer> playerNumbers, int strikes) {
        return countMatchingNumbers(computerNumbers, playerNumbers) - strikes;
    }

    /**
     * 두 리스트에서 일치하는 숫자의 개수를 계산하는 메소드 (볼 개수 계산을 위함)
     * @param list1 첫 번째 리스트
     * @param list2 두 번째 리스트
     * @return 일치하는 숫자의 개수
     */
    private int countMatchingNumbers(List<Integer> list1, List<Integer> list2) {
        int matchingNumbers = 0;
        for (Integer number : list1) {
            if (list2.contains(number)) {
                matchingNumbers++;
            }
        }
        return matchingNumbers;
    }
}
