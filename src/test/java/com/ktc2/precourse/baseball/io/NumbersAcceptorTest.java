package com.ktc2.precourse.baseball.io;

import com.ktc2.precourse.baseball.object.Numbers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumbersAcceptorTest {
    static final String[] fails = {
            "", //null test
            "a33", "5사1", "1b9", "3a2", //not digit test
            "1", "12", "y", //less length test
            "1234", "17234", //long length test
            "112", "133", "558", //duplicate test
            "103", "084", "810" //include zero test
    };
    NumbersAcceptor a;
    InputStream sysInBackup;

    @BeforeEach
    void setUp() {
        sysInBackup = System.in;
        a = new NumbersAcceptor();
    }

    @AfterEach
    void tearDown() {
        System.setIn(sysInBackup);
    }

    @Test
    void getDtoBySystemIn() {
        //Valid Test
        //가능한 모든 3자리 숫자에 대해 테스트함
        String s = "123456789";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 9; k++) {
                    if (k == j || k == i) {
                        continue;
                    }

                    //System.in 입력을 문자열로 대신하기 위함임
                    System.setIn(toSysIn("" + s.charAt(i) + s.charAt(j) + s.charAt(k)));
                    assertThat(a.getDtoBySystemIn())
                            .isEqualTo(new Numbers(s.charAt(i) - '0', s.charAt(j) - '0', s.charAt(k) - '0'));
                }
            }
        }

        //invalid test
        for (String f: fails) {
            System.setIn(toSysIn(f));
            assertThrows(IllegalArgumentException.class, () -> a.getDtoBySystemIn());
        }
    }

    InputStream toSysIn(String input) {
        input = input + "\n";
        return new ByteArrayInputStream(input.getBytes());
    }
}