public class Application {
    public static void main(String[] args) {
        int restart= 0;//0은 의미 없는 숫자, Re 클래스의 retartok()를 통해 restart 값은 여러번 재정의 된다.

        do {
            Randomint rd = new Randomint();
            int[] arr1 = new int[3];//컴퓨터 3자리수 배열
            rd.randint(arr1);
            int st, ba; // do while문의 조건문 때문에 밖으로 빼기 => (st != 3)

            do {
                int[] arr2 = new int[3];//사용자 입력 3자리수 배열, 틀릴때 마다 재입력되므로 do while문 안에 집어넣는다.
                rd.myint(arr2);

                StrikeOrBall sb = new StrikeOrBall();

                st = sb.strike(arr1, arr2);//스트라이크 값 계산
                ba = sb.ball(arr1, arr2);//볼 값 계산
                ba = ba - st; //ball과 strike가 중복되지 않도록 계산

                Print pr = new Print();
                pr.result(ba, st);//결과값 프린트
            } while (st != 3);//스트라이크가 3이 아니면(=정답을 맞추지 못하면) 계속 반복

            if (st == 3) {
                Re re = new Re();
                restart = re.retartok();//재시작 여부 묻기
            }
        }while(restart==1);//restart 값이 1일때 계속 반복
    }
}