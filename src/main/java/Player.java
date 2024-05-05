import java.util.Scanner;
import java.util.Vector;

public class Player {
    private Vector<Integer> num;

    public Vector<Integer> getNum() {
        return num;
    }

    public void pickNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        int temp = scanner.nextInt();
        if(temp < 111 || temp > 999)
            throw new IllegalArgumentException("Invalid argument: " + temp);

        num = new Vector<Integer>();
        num.add(temp / 100);
        num.add((temp / 10) % 10);
        num.add(temp % 10);
    }
}
