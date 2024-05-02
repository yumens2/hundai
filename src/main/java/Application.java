import java.util.HashSet;
import java.util.Scanner;

public class Application {
    static HashSet<Integer> hs;
    public static void main(String[] args) {
        int flag=1;
        Scanner sc = new Scanner(System.in);
        while(flag==1){
            String question = getNumber();
            while(true){
                System.out.print("숫자를 입력해 주세요 : ");
                String answer = sc.nextLine();
                checkThreeNum(answer);

                System.out.println(giveResult(question, answer));
                if (question.equals(answer)) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    flag = Integer.parseInt(sc.nextLine());
                    break;
                }
            }
        }
    }
    public static String getNumber(){

    }
    public static void checkThreeNum(String answer){

    }
    public static String giveResult(String question, String answer){

    }
}
