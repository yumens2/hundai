//컴퓨터가 랜덤으로 숫자 3개를 선택합니다.

import java.util.Random;

public class CreateNumber {

    public static int[] create(){

        int[] computerNum = new int[3];
        /*for(int i=0;i<3;i++){
            computerNum[i] = (int)(Math.random()*10);
        }*/
        for(int i=0;i<3;i++){
            Random random = new Random();
            computerNum[i] = random.nextInt(9)+1;
        }

        if (computerNum[0] == computerNum[1] || computerNum[0] == computerNum[2] ||computerNum[1] == computerNum[2]){
            create();
        }
        return computerNum;
    }

}
