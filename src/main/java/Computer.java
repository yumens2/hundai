import java.util.Random;
import java.util.Vector;

public class Computer {
    private Vector<Integer> num;

    /**
     * 생성자를 이용하여 생성 시 무작위 숫자를 생성하도록 생성자 설정
     */
    public Computer(){
        num = new Vector<Integer>();
        makeNumber();
    }

    public Vector<Integer> getNum(){
        return num;
    }

    /**\
     * 무작위 숫자를 생성하는 메서드, 중복된 숫자가 없어야 하므로 Vector의 contains() 메서드를 이용
     */
    private void makeNumber(){
        Random rd = new Random();
        while(num.size() != 3) {
            int temp = rd.nextInt(8) + 1;
            if (!num.contains(temp)) num.add(temp);
        }
    }
}
