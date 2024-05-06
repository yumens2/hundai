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

    public int[] compare(List<Integer> a, List<Integer> b) {
        int strikeNum = 0;
        int ballNum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                strikeNum += isStrike(a.get(i), b.get(j), i, j);
                ballNum += isBall(a.get(i), b.get(i), i, j);
            }
        }
        return new int[]{strikeNum, ballNum};
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
