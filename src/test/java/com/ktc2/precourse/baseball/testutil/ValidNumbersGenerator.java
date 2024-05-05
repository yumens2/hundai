package com.ktc2.precourse.baseball.testutil;

import java.util.Iterator;

public class ValidNumbersGenerator implements Iterator<String> {
    private boolean hasNext;
    private int i;
    private int j;
    private int k;

    public ValidNumbersGenerator() {
        hasNext = true;
        i = 0;
        j = 1;
        k = 1;
    }

    private void nextI() {
        if (++i == 9) {
            i = 0;
        }
    }

    private void nextJ() {
        if (++j == 9) {
            j = 0;
            nextI();
        }
        if (j == i) {
            nextJ();
        }
    }

    private void nextK() {
        if (++k == 9) {
            k = 0;
            nextJ();
        }
        if (k == j || k == i) {
            nextK();
        }
        if (i == 8 && j == 7 && k == 6) {
            hasNext = false;
        }
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public String next() {
        nextK();
        String seed = "123456789";
        return String.valueOf(seed.charAt(i)) + seed.charAt(j) + seed.charAt(k);
    }
}
