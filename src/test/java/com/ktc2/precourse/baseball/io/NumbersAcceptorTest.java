package com.ktc2.precourse.baseball.io;

import com.ktc2.precourse.baseball.io.acceptor.NumbersAcceptor;
import com.ktc2.precourse.baseball.object.Numbers;
import com.ktc2.precourse.baseball.testutil.ValidNumbersGenerator;
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
        ValidNumbersGenerator gen = new ValidNumbersGenerator();

        while (gen.hasNext()) {
            String s = gen.next();

            sysIn(s); //System.in 입력을 문자열로 대신하기 위함임
            assertThat(a.getDtoBySystemIn())
                    .isEqualTo(new Numbers(s.charAt(0) - '0', s.charAt(1) - '0', s.charAt(2) - '0'));
            System.out.println(s);
        }

        //invalid test
        for (String f: fails) {
            sysIn(f);
            assertThrows(IllegalArgumentException.class, () -> a.getDtoBySystemIn());
        }
    }

    void sysIn(String input) {
        input = input + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}