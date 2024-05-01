import java.util.ArrayList;
import java.util.List;

public class Player {
    /**
     * 입력 받은 값을 ArrayList로 변환한다.
     * @return 입력을 ArrayList로 변환하여 반환
     */
    public List<Integer> convertInputToList(String input){
        validateInput(input); // 입력값 유효성 검사

        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch)); // char를 int로 변환하여 리스트에 추가
        }
        return numbers;
    }

    /**
     * 입력받은 숫자가 유효하지 않으면 Exception을 발생시키는 메소드
     * @param input
     */
    private void validateInput(String input) {
        if (!isValidInput(input)) {
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다: " + input);
        }
    }

    /**
     * 입력 숫자가 유효한지 확인하는 메소드
     * @param input
     * @return 유효하면 True
     */
    private boolean isValidInput(String input) {
        return input != null && input.length() == 3 && input.matches("\\d+");
    }

}
