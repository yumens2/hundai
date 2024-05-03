package main.java;
import java.util.Random;
import java.util.Scanner;

public class Number{
    boolean FLAG;
    int[] RANDOM_NUM=new int[3];
    int MY_NUM;
    int BALL;
    int STRIKE;
    public Number() {
        FLAG=true;
        BALL=0; STRIKE=0;
        RANDOM_NUM[0]=(int)(10*Math.random());
        while(true){
            RANDOM_NUM[1]=(int)(10*Math.random());
            if(RANDOM_NUM[0]!=RANDOM_NUM[1]) break;
        }
        while(true){
            RANDOM_NUM[2]=(int)(10*Math.random());
            if(RANDOM_NUM[0]!=RANDOM_NUM[2]&&RANDOM_NUM[1]!=RANDOM_NUM[2]) break;
        }
    }
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