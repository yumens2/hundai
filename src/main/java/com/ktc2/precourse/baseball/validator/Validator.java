package com.ktc2.precourse.baseball.validator;

/**
 * object의 유효성을 확인하는 클래스
 * @param <T> 유효성 확인할 object 타입
 */
public interface Validator <T> {

    /**
     * object의 유효성을 확인한다.
     * @param object 유효성을 확인할 객체
     * @return 유효한 객체인지 여부
     */
    boolean isValid(T object);
}
