import java.util.Random;
import java.util.Scanner;

public class Baseball {


    public static void main(String[] args) {
        int player_number;
        int random_number;
        int score=0;
        int mode=0;

        random_number = get_rand();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("문자 3개 써라 : ");
            player_number = get_num();
            BaseballVO vo= new BaseballVO(player_number , random_number);
            vo.make_array();
            vo.compare();
            //System.out.println("random : "+random_number);
            //System.out.println("player : " + player_number);
            vo.print_answer();
            if (vo.set_answer() == 300){
                System.out.println("3개의 숫자를 모두 맞히셨습니다!  게임종료");
                System.out.println("게임을 세로 시작하려면 1 , 종료하려면 2를 입력해주세요");
                mode = scanner.nextInt();
                random_number=to_be_continue(mode);
            }
        }while(mode !=2 );
    }//main end



    public static int to_be_continue(int mode) {
        int again;
        again = get_rand();
        if (mode == 1) {
            return again;
        }
        else {
            System.out.println("see you next time!");
            return 0;
        }
    }// 계속할지 말지 판단하는 메서드


    public static int find_same_number(int  number){
        int tri=0;
        int [] a = new int[3];
        // 1이면 중복수 있음 0 이면 없음
        for (int i=0; i<3; i++) {
            a[i] = number % 10;
            number = number / 10;
        }
        if (a[0] == a[2]){
            tri++;
        }
        if (a[0] == a[1]){
            tri++;
        }
        if (a[1] == a[2]){
            tri++;
        }
        if (tri ==0) {
            return 0;
        }
        else {
            return 1;
        }
    } // 3자리 숫자 중에서 같은숫자 있으면 1 없으면 0


    public static int find_zero(int  number){
        int tri=0;
        if (number%10 ==0){
            tri=1;
        }
        number = number/10;
        if (number %10==0){
            tri=1;
        }
        return tri;
    }// 숫자에 0이 있으면 1 없으면0



    public static int error_list(int num) {
        int error=0;
        // 0이면 정상 , 1 이면 에러
        if (num >=1000 | num<100){
            System.out.println("숫자 3개 입력하라니까ㅜ");
            error=1;
        }
        if (find_same_number(num) == 1) {
            System.out.println("같은숫자 쓰지 말라니까ㅜ");
            error = 1;
        }
        if (find_zero(num)==1){
            System.out.println("0쓰지 말라니까ㅜ");
            error=1;
        }
        return error;
    }// 에러 모음집


    public static int get_num() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (error_list(num) ==1) {
            throw new IllegalArgumentException("꺼질게~");
        }
        else {
            return num;
        }
    }// 입력받은 숫자가 올바른지 판단.


    public static int get_rand() {
        int rand;
        do {
            Random random = new Random();
            rand=random.nextInt(900) + 100;
        }while (error_list(rand) !=0);
        return rand;
    }// 랜덤숫자가 올바른지 판단.

}
