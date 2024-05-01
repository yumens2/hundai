package main.java;

import java.util.Random;

public class Answer {
    private int num1;
    private int num2;
    private int num3;
    public Answer(){
        Random random = new Random();
        num1 = random.nextInt(1, 10);
        num2 = num1;
        while(num1 == num2)
            num2 = random.nextInt(1, 10);
        num3 = num2;
        while(num1 == num3 || num2 == num3)
            num3 = random.nextInt(1, 10);
    }
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int answerNum(){
        return num1 * 100 + num2 * 10 + num3;
    }
}
