import java.util.Scanner;

public class OneGameProgress {



    public boolean gameRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        try{
            int num = sc.nextInt();
            if (num ==1) {
                return true;
            } else if (num == 2) {
                return false;
            }else {
                throw new IllegalArgumentException();
            }

        }catch (IllegalArgumentException e){
            throw e;
        }


    }
}
