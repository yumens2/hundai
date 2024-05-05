import java.util.Scanner;

class Re{
    int restart;
    boolean re;

    Re(){
        restart=1;
        re=false;
    }

    //재시작(1) 또는 종료(2) 확인하기
    public int retartok(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        while(re==false) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = scanner.nextInt();
            if (restart== 1 || restart== 2) {
                re= true;
            }
        }//1또는 2가 아닌 숫자가 입력되면 무한 반복

        return restart;
    }
}
