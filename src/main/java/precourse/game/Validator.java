package precourse.game;

import precourse.utils.DigitUtil;
import precourse.utils.StringUtil;

//TODO: 구현하기
//숫자를 어떻게 처리하느냐에 따라 다른 검증기를 사용할 수도 있을거 같고 (다른 타입을 어떻게 다룰지는 모르겠음)
//람다 전략 패턴을 사용할 수도 있을거 같고
//제네릭스를 이용해도 될거 같은데 - extends Validator<String>, <List<Integer>>
//doTurn, init 메서드명이 변경되면 이것도 바뀌어야 하는데 강제할 수 있는 다른 방법이 없을지?
//일단 구현하고 고민하기
public class Validator {
    public void validateStartRoundInput(int numberLength){
        if (!DigitUtil.isOneDigitOfPositive(numberLength))
            throw new IllegalArgumentException(Messages.INVALID_NUMBER_LENGTH.getMessage());
    }
    public void validatePlayTurnInput(String numbers, String userNumbers){
        if (numbers.length() != userNumbers.length()) {
            throw new IllegalArgumentException(Messages.NOT_MATCHED_LENGTH.getMessage());
        }
        if (!DigitUtil.isDigitsOfPositive(userNumbers)) {
            throw new IllegalArgumentException(Messages.INVALID_NUMBER.getMessage());
        }
        if (!StringUtil.isEachCharUnique(userNumbers)) {
            throw new IllegalArgumentException(Messages.NOT_UNIQUE_DIGITS.getMessage());
        }
    }
}
