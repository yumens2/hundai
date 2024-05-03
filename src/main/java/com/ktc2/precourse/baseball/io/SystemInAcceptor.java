package com.ktc2.precourse.baseball.io;

/**
 *  표준 입력(System.in)으로부터 올바른 입력을 받는 클래스
 */
public abstract class SystemInAcceptor<D> {

    /**
     * input이 올바른 입력인지 확인한다.
     * @param input System.in으로부터의 String
     * @return 올바른 입력인지 여부
     */
    protected abstract boolean validate(String input);

    /**
     * input으로부터 올바른 DTO를 생성한다.
     * @param input
     * @return
     */
    protected abstract D mapToDto(String input);

    /**
     * 표준 입력을 분석한 후 해당하는 DTO를 반환한다.
     * @return
     * @throws IllegalArgumentException
     */
    public D getDtoBySystemIn() {
        return null;
    }
}
