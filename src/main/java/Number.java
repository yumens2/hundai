package main.java;
import java.util.Random;
import java.util.Scanner;

public class Number{
    boolean FLAG;
    int[] RANDOM_NUM=new int[3];
    int MY_NUM;
    int BALL;
    int STRIKE;
    public void chkEquality() throws Exception {
        boolean FLAGNUM1=true;
        while(FLAGNUM1){
            getNum();
            compareNum();
            if(STRIKE==3) {
                finishedGame();
                return;
            }
            FLAGNUM1=FLAG;
        }
    }
}