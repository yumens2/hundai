import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    public List<Integer> setComNum() {
        Random r = new Random();
        List<Integer> comNum = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            comNum.add(r.nextInt(1, 9));
        }
        return comNum;

    }

    public boolean compare(List<Integer> a, List<Integer> b) {
        int strikeNum = 0;
        int ballNum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                strikeNum += isStrike(a.get(i), b.get(j), i, j);
                ballNum += isBall(a.get(i), b.get(i), i, j);
            }
        }
        if (strikeNum ==3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if(strikeNum !=0 && ballNum !=0){
            System.out.printf("%d볼 %d스트라이크/n",ballNum,strikeNum);
            return false;
        } else if(strikeNum ==0 & ballNum !=0){
            System.out.printf("%d볼/n",ballNum);
            return false;
        } else if(strikeNum !=0 & ballNum ==0){
            System.out.printf("%d스트라이크/n",strikeNum);
            return false;
        } else if(strikeNum ==0 & ballNum ==0){
            System.out.println("낫싱");
            return false;
        } else{
            return false; // 이부분 수정 필요
        }
    }

    public int isStrike(int aNum, int bNum, int aIdx, int bIdx) {
        if ((aNum == bNum) && (aIdx == bIdx)) {
            return 1;
        } else {
            return 0;
        }
    }
    public int isBall(int aNum, int bNum,int aIdx,int bIdx){
        if ((aNum == bNum) && (aIdx!=bIdx)) {
            return 1;
        }else {
            return 0;
        }
    }


}
