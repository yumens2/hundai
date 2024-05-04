import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {
    private static final int NUM_LENGTH = 3;         // 숫자 최대 길이

    private String randNum;                         // Random number
    private int strikeScore;                        // 스트라이크 점수
    private int ballScore;                          // 볼 점수

    public Computer() {}

    public String getRandNum() {
        return randNum;
    }

    public int getStrikeScore() {
        return strikeScore;
    }

    public int getBallScore() {
        return ballScore;
    }

    /**
     * Random number 생성하는 Setter
     */
    public void generateRandNum() {
        Set<Integer> set = new HashSet<Integer>();
        while(set.size() < NUM_LENGTH) {
            set.add((int)(Math.random() * 9 + 1));
        }

        StringBuilder randNum = new StringBuilder();
        for (Integer num : set) {
            randNum.append((char) (num + '0'));
        }
        this.randNum = randNum.toString();
    }

    /**
     * inputNum 유효성 검증
     * @param inputNum 입력된 수
     */
    public void inputValidationCheck(String inputNum) {
        if (!isInputValid(inputNum)) {
            throw new IllegalArgumentException("Invalid argument: " + inputNum);
        }
    }

    /**
     * 각 유효 조건을 만족하는지 여부 확인
     * @param inputNum
     * @return 유효 조건 모두 만족 시 true 반환
     */
    private boolean isInputValid(String inputNum) {
        return inputLengthCheck(inputNum) && inputDuplicationCheck(inputNum) && inputDomainCheck(inputNum);
    }

    /**
     * 입력값 길이 검증
     * @param inputNum
     * @return NUM_LENGTH와 동일하면 true
     */
    private boolean inputLengthCheck(String inputNum) {
        return inputNum.length() == NUM_LENGTH;
    }

    /**
     * 입력값 중복 여부 검증
     * @param inputNum
     * @return 중복이 없으면 true
     */
    private boolean inputDuplicationCheck(String inputNum) {
        Set<Character> set = inputNum.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
        return set.size() == NUM_LENGTH;
    }

    /**
     * 입력값이 모두 숫자인지 검증
     * @param inputNum
     * @return 모두 숫자이면 true
     */
    private boolean inputDomainCheck(String inputNum) {
        return inputNum.matches("^[1-9]+$");
    }

    /**
     * User의 inputNum에 대한 점수를 계산
     * @param inputNum User의 inputNum
     */
    public void calcScore(String inputNum) {
        strikeScore = ballScore = 0;
        for(int i = 0; i < inputNum.length(); i++) {
            if(isStrike(inputNum, i)) {
                strikeScore++;
            } else if(isBall(inputNum, i)) {
                ballScore++;
            }
        }
    }

    /**
     * 스트라이크인지 판단
     * @param inputNum 입력된 수
     * @param idx 확인할 숫자의 위치(인덱스)
     * @return 스트라이크라면 true를 반환
     */
    private boolean isStrike(String inputNum, int idx) {
        return inputNum.charAt(idx) == randNum.charAt(idx);
    }

    /**
     * 볼인지 판단
     * @param inputNum 입력된 수
     * @param idx 확인할 숫자의 위치(인덱스)
     * @return 볼이라면 true 반환
     */
    private boolean isBall(String inputNum, int idx) {
        for(int i = 0; i < inputNum.length(); i++) {
            if(idx != i && inputNum.charAt(idx) == randNum.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 추측 결과를 출력
     */
    public void printScore() {
        if(isNothing()) {
            System.out.println("낫싱");
            return;
        }
        if(ballScore > 0) {
            System.out.print(ballScore + "볼 ");
        }
        if(strikeScore > 0) {
            System.out.print(strikeScore + "스트라이크 ");
        }
        System.out.println();
    }

    /**
     * 볼과 스트라이크가 모두 해당되지 않는지 확인
     * @return 볼과 스트라이크 모두 없으면 true를 반환
     */
    private boolean isNothing() {
        return ballScore == 0 && strikeScore == 0;
    }

    /**
     * 유저 입력 안내 메시지 출력
     */
    public void printInputMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    /**
     * 게임이 끝났을 경우의 출력
     */
    public void printFinishMessage() {
        System.out.println(NUM_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /**
     * 3스트라이크로 게임이 끝났는지 확인
     * @return 3스트라이크이면 true
     */
    public boolean isGameFinish() {
        return strikeScore == NUM_LENGTH;
    }
}
