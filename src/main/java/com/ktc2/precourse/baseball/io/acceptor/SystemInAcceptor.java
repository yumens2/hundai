package com.ktc2.precourse.baseball.io.acceptor;

import com.ktc2.precourse.baseball.io.logger.TerminalLogger;
import com.ktc2.precourse.baseball.validator.Validator;

import java.util.Scanner;

/**
 *  표준 입력(System.in)으로부터 올바른 입력을 받는 클래스
 */
public abstract class SystemInAcceptor<D> {

    /**
     * 유효한 input으로부터 올바른 DTO를 생성한다.
     * @param input validator로부터 검증된 유효한 input
     * @return 변환된 DTO
     */
    protected abstract D mapToDto(String input);

    /**
     * Acceptor 사용시 사용할 TerminalLogger를 반환한다.
     * @return TerminalLogger
     */
    protected abstract TerminalLogger getLogger();

    /**
     * System.in을 검증할 Validator를 반환한다.
     * @return Validator
     */
    protected abstract Validator<String> getValidator();

    /**
     * 표준 입력을 분석한 후 해당하는 DTO를 반환한다.
     * @return System.in으로부터 변환된 DTO
     * @throws IllegalArgumentException System.in 입력값이 유효하지 않은 경우
     */
    public final D getDtoBySystemIn() throws IllegalArgumentException {
        getLogger().log();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (!getValidator().isValid(input)) {
            throw new IllegalArgumentException();
        }

        return mapToDto(input);
    }
}
