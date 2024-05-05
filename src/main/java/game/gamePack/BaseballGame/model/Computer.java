package game.gamePack.BaseballGame.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBER_LENGTH = 3;
    //private static Computer computer;

    private Computer() {
    }

//    public static Computer of() {
//        if (computer == null) {
//            computer = new Computer();
//        }
//        return computer;
//    }

    /**
     * static inner class를 이용한 싱글톤 패턴 클래스가 로딩될 때 생성되기 때문에 thread-safe 함 lazy loading이 가능하며, of()
     * 메소드가 호출되기 전까지는 객체가 생성되지 않음
     */
    private static class ComputerHolder {

        private static final Computer computer = new Computer();
    }

    public static Computer getInstance() {
        return ComputerHolder.computer;
    }


    /**
     * 랜덤 숫자 반환
     *
     * @return 랜덤 숫자 리스트
     */
    public List<Integer> getTargetNumbers() {
        return createTargetNumbers();
    }

    private List<Integer> createTargetNumbers() {
        List<Integer> numbers = pickRandomNumber();
        while (isDuplicate(numbers)) {
            numbers = pickRandomNumber();
        }
        return numbers;
    }


    private List<Integer> pickRandomNumber() {
        return Arrays.stream(new List[NUMBER_LENGTH])
            .map(i -> (int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER)
            .collect(Collectors.toList());
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != NUMBER_LENGTH;
    }

}
