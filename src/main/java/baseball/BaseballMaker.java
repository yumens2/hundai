package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballMaker {

    //게임생성 List로 변환
    public List<Integer> makeBaseball(){
        List<Integer> baseball=new ArrayList<>();
        int[] numbers=makeNumbers();
        for(int i=0; i<3; i++){
            baseball.add(numbers[i]);
        }
        return baseball;
    }
    //게임배열 생성
    public int[] makeNumbers(){
        int[] numbers =new int[3];
        int i=0;
        boolean done=false;
        while(!done){
            int num= (int)(Math.random()*9+1);
            if(checkPossible(num,i+1,numbers)){
                numbers[i]=num;
                i++;
            }
            else{
                continue;
            }
            if(i>=3){
                done=true;
            }
        }

        return numbers;
    }
    //생서할때 가능한 숫자인지 체크
    public boolean checkPossible(int num,int index, int[] numbers){
        for(int i=0; i<index; i++) {
            if (numbers[i] == num) {
                return false;
            }
        }
        return true;

    }
}
