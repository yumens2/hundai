import java.util.Scanner;

public class Input {
    public int[] PlayerNum(){
        Scanner sc = new Scanner(System.in);
        int[] playerNum = new int[3];
        System.out.print("숫자를 입력해 주세요 : ");
        String in = sc.nextLine();
        for (int i=0;i<3;i++){
            playerNum[i]=in.charAt(i)-'0';
        }
        return playerNum;
    }

}
