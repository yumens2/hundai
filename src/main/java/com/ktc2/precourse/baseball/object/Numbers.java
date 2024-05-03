package com.ktc2.precourse.baseball.object;

public class Numbers {
    public static final int LENGTH = 3;
    private final int[] number = new int[LENGTH];

    public Numbers(int a, int b, int c) {
        number[0] = a;
        number[1] = b;
        number[2] = c;
    }

    public int get(int index) {
        return number[index];
    }

    @Override
    public String toString() {
        return "Numbers(" + number[0] + ", " + number[1] + ", " + number[2] + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Numbers)) {
            return false;
        }

        for (int i = 0; i < LENGTH; i++) {
            if (((Numbers) obj).number[i] != this.number[i]) {
                return false;
            }
        }

        return true;

    }
}
