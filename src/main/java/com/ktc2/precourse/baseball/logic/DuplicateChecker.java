package com.ktc2.precourse.baseball.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * 입력된 일렬의 원소들 중 중복이 있는지 검사한다.
 * @param <T> 검사할 원소의 타입
 */
public class DuplicateChecker <T> {
    private final Set<T> container = new HashSet<>();

    /**
     * 해당 원소의 중복 여부를 체크한다.
     * @param data 중복 여부를 체크할 원소
     * @return 중복된 원소면 true, 아니면 false 반환
     */
    public boolean check(T data) {
        return !container.add(data);
    }
}
