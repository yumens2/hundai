package com.ktc2.precourse.baseball.validator;

public interface Validator <T> {

    /**
     * object의 유효성을 확인한다.
     * @param object 유효성을 확인할 객체
     * @return 유효한 객체인지 여부
     */
    boolean isValid(T object);
}
