package com.ktc2.precourse.baseball.io;

import com.ktc2.precourse.baseball.object.Retry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RetryAcceptorTest {
    static final String[] fails = {
            null, "", "12", "21", "a", "ab", "a1", "5"
    };

    InputStream sysInBackup;

    RetryAcceptor a;

    @BeforeEach
    void setUp() {
        sysInBackup = System.in;
        a = new RetryAcceptor();
    }

    @AfterEach
    void tearDown() {
        System.setIn(sysInBackup);
    }

    @Test
    void getDtoBySystemIn() {
        //Valid Test
        System.setIn(toSysIn("1"));
        assertThat(a.getDtoBySystemIn()).isEqualTo(Retry.CONTINUE);
        System.setIn(toSysIn("2"));
        assertThat(a.getDtoBySystemIn()).isEqualTo(Retry.EXIT);

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